package cn.lili.controller.admin.bank;

import cn.lili.cache.Cache;
import cn.lili.common.enums.ResultUtil;
import cn.lili.common.vo.PageVO;
import cn.lili.common.vo.ResultMessage;
import cn.lili.common.vo.SearchVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 管理端,订单API
 *
 * @author Chopper
 * @since 2020/11/17 4:34 下午
 */
@RestController
@RequestMapping("/manager/background/info")
@Api(tags = "管理端,卡片api")
public class BackgroundManagerController {

    /**
     * 卡片
     */
    @Autowired
    private Cache cache;


    @ApiOperation(value = "查询卡片列表分页")
    @GetMapping
    public ResultMessage<IPage<Map<String,Object>>> queryMineOrder(Map<String,Object> map,
                                                        SearchVO searchVo,
                                                        PageVO page) {
        Map hash = cache.getHash("background:info");
        IPage<Map<String,Object>> result   = new Page<>();
        List<Map<String,Object>> maps = Lists.newArrayList();
        maps.add(hash);
        result.setRecords(maps);
        return ResultUtil.data(result);
    }

    @ApiOperation(value = "更新卡片列表分页")
    @PostMapping("/add")
    public ResultMessage<Boolean> addMineOrder(@RequestBody Map map) {
        cache.putAllHash("background:info",map);
        return ResultUtil.data(Boolean.TRUE);
    }

}