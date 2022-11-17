package cn.lili.modules.member.serviceimpl;

import cn.hutool.core.util.ObjectUtil;
import cn.lili.common.enums.ResultCode;
import cn.lili.common.exception.ServiceException;
import cn.lili.common.security.context.UserContext;
import cn.lili.common.vo.PageVO;
import cn.lili.modules.goods.entity.dos.Category;
import cn.lili.modules.goods.entity.dos.GoodsSku;
import cn.lili.modules.goods.service.CategoryService;
import cn.lili.modules.goods.service.GoodsSkuService;
import cn.lili.modules.member.entity.dos.GoodsCollection;
import cn.lili.modules.member.entity.vo.GoodsCollectionVO;
import cn.lili.modules.member.mapper.GoodsCollectionMapper;
import cn.lili.modules.member.service.GoodsCollectionService;
import cn.lili.modules.order.order.entity.vo.OrderSimpleVO;
import cn.lili.mybatis.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 会员收藏业务层实现
 *
 * @author Chopper
 * @since 2020/11/18 2:25 下午
 */
@Service
public class GoodsCollectionServiceImpl extends ServiceImpl<GoodsCollectionMapper, GoodsCollection> implements GoodsCollectionService {

    @Autowired
    private HttpServletRequest request; //自动注入request*

    @Autowired
    private GoodsSkuService categoryService;

    @Override
    public IPage<GoodsCollectionVO> goodsCollection(PageVO pageVo) {
        QueryWrapper<GoodsCollectionVO> queryWrapper = new QueryWrapper();
        queryWrapper.eq("gc.member_id", UserContext.getCurrentUser().getId());
        queryWrapper.groupBy("gc.id");
        queryWrapper.orderByDesc("gc.create_time");
        IPage<GoodsCollectionVO> goodsCollectionVOIPage = this.baseMapper.goodsCollectionVOList(PageUtil.initPage(pageVo), queryWrapper);
        String lang = request.getHeader("LANG");
        for (GoodsCollectionVO record : goodsCollectionVOIPage.getRecords()) {
            if(ObjectUtil.isNotEmpty(record.getGoodsName())){
                List<GoodsSku> list = categoryService.list(Wrappers.<GoodsSku>lambdaQuery()
                        .eq(GoodsSku::getGoodsName,record.getGoodsName()));
                Map<String, GoodsSku> categoryMap = list.stream().collect(Collectors.toMap(GoodsSku::getGoodsName, x -> x,(z, y)->z));
                if("zh-Hant".equals(lang)){
                    record.setGoodsName(categoryMap.get(record.getGoodsName()).getGoodsMyName());
                }
                else if("en".equals(lang)){
                    record.setGoodsName(categoryMap.get(record.getGoodsName()).getGoodsUkName());
                }
            }

        }
        return goodsCollectionVOIPage;
    }

    @Override
    public boolean isCollection(String skuId) {
        QueryWrapper<GoodsCollection> queryWrapper = new QueryWrapper();
        queryWrapper.eq("member_id", UserContext.getCurrentUser().getId());
        queryWrapper.eq(skuId != null, "sku_id", skuId);
        return Optional.ofNullable(this.getOne(queryWrapper)).isPresent();
    }

    @Override
    public GoodsCollection addGoodsCollection(String skuId) {
        GoodsCollection goodsCollection = this.getOne(new LambdaUpdateWrapper<GoodsCollection>()
                .eq(GoodsCollection::getMemberId, UserContext.getCurrentUser().getId())
                .eq(GoodsCollection::getSkuId, skuId));
        if (goodsCollection == null) {
            goodsCollection = new GoodsCollection(UserContext.getCurrentUser().getId(), skuId);

            this.save(goodsCollection);
            return goodsCollection;
        }
        throw new ServiceException(ResultCode.USER_COLLECTION_EXIST);
    }

    @Override
    public boolean deleteGoodsCollection(String skuId) {
        QueryWrapper<GoodsCollection> queryWrapper = new QueryWrapper();
        queryWrapper.eq("member_id", UserContext.getCurrentUser().getId());
        queryWrapper.eq(skuId != null, "sku_id", skuId);
        return this.remove(queryWrapper);
    }

    @Override
    public boolean deleteGoodsCollection(List<String> goodsIds) {
        QueryWrapper<GoodsCollection> queryWrapper = new QueryWrapper();
        queryWrapper.in("sku_id", goodsIds);
        return this.remove(queryWrapper);
    }

    @Override
    public boolean deleteSkuCollection(List<String> skuIds) {
        QueryWrapper<GoodsCollection> queryWrapper = new QueryWrapper();
        queryWrapper.in("sku_id", skuIds);
        return this.remove(queryWrapper);
    }
}