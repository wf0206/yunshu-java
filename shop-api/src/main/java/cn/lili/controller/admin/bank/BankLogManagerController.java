package cn.lili.controller.admin.bank;

import cn.hutool.core.util.ObjectUtil;
import cn.lili.common.enums.ResultCode;
import cn.lili.common.enums.ResultUtil;
import cn.lili.common.vo.PageVO;
import cn.lili.common.vo.ResultMessage;
import cn.lili.common.vo.SearchVO;
import cn.lili.modules.bank.entity.BankLog;
import cn.lili.modules.bank.service.BankLogService;
import cn.lili.modules.member.entity.vo.MemberVO;
import cn.lili.modules.member.service.MemberService;
import cn.lili.mybatis.util.PageUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理端,订单API
 *
 * @author Chopper
 * @since 2020/11/17 4:34 下午
 */
@RestController
@RequestMapping("/manager/bank/log")
@Api(tags = "管理端,卡片api")
public class BankLogManagerController {

    /**
     * 卡片
     */
    @Autowired
    private BankLogService bankLogService;
    @Autowired
    private MemberService memberService;


    @ApiOperation(value = "查询卡片列表分页")
    @GetMapping
    public ResultMessage<IPage<BankLog>> queryMineOrder(BankLog entity,
                                                              SearchVO searchVo,
                                                              PageVO page) {
        Page<BankLog> page1 = bankLogService.page(PageUtil.initPage(page), PageUtil.initWrapper(entity, searchVo));
        for (BankLog record : page1.getRecords()) {
            MemberVO member = memberService.getMember(record.getUserId());
            record.setPhone(member.getMobile());
            record.setUuid(member.getGradeId());
        }
        return ResultUtil.data(page1);
    }

    @ApiOperation(value = "更新卡片列表分页")
    @PutMapping
    public ResultMessage<Boolean> queryMineOrder(BankLog entity) {
        entity.setBankStatus("1");
        boolean b = bankLogService.updateById(entity);
        return ResultUtil.data(b);
    }

}