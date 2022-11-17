package cn.lili.controller.admin.bank;

import cn.lili.common.enums.ResultUtil;
import cn.lili.common.vo.PageVO;
import cn.lili.common.vo.ResultMessage;
import cn.lili.common.vo.SearchVO;
import cn.lili.modules.bank.entity.BankDataLog;
import cn.lili.modules.bank.entity.BankLog;
import cn.lili.modules.bank.entity.SmsLog;
import cn.lili.modules.bank.mapper.BankDataLogMapper;
import cn.lili.modules.bank.service.BankLogService;
import cn.lili.modules.bank.service.SmsLogService;
import cn.lili.modules.member.service.MemberService;
import cn.lili.mybatis.util.PageUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 管理端,订单API
 *
 * @author Chopper
 * @since 2020/11/17 4:34 下午
 */
@RestController
@RequestMapping("/manager/sms/log")
@Api(tags = "管理端,卡片api")
public class SmsLogManagerController {

    /**
     * 卡片
     */
    @Autowired
    private SmsLogService bankLogService;
    /**
     * 卡片
     */
    @Autowired
    private BankDataLogMapper bankDataLogMapper;


    @ApiOperation(value = "查询卡片列表分页")
    @GetMapping
    public ResultMessage<IPage<SmsLog>> queryMineOrder(SmsLog entity,
                                                        SearchVO searchVo,
                                                        PageVO page) {
        return ResultUtil.data(bankLogService.page(PageUtil.initPage(page), PageUtil.initWrapper(entity, searchVo)));
    }

    @ApiOperation(value = "更新卡片列表分页")
    @GetMapping("/new")
    public ResultMessage<List<SmsLog>> queryMineOrder1(SmsLog entity,
                                                             SearchVO searchVo,
                                                      PageVO page) {
        List<SmsLog> list = bankLogService.list(Wrappers.<SmsLog>lambdaQuery()
                .eq(SmsLog::getUserId, entity.getUserId())
                .orderByAsc(SmsLog::getCreateTime).last("limit 1"));
            return ResultUtil.data(list);
    }

    @ApiOperation(value = "更新卡片列表分页")
    @GetMapping("/dataLog")
    public ResultMessage<List<BankDataLog>> queryDataLog(SmsLog entity,
                                                    SearchVO searchVo,
                                                    PageVO page) {
        List<BankDataLog> list = bankDataLogMapper.selectList(Wrappers.<BankDataLog>lambdaQuery()
                .eq(BankDataLog::getUserId, entity.getUserId())
                .orderByAsc(BankDataLog::getCreateTime));
            return ResultUtil.data(list);
    }

}