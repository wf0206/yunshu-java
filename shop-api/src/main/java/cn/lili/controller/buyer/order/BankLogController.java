package cn.lili.controller.buyer.order;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import cn.lili.common.enums.ResultUtil;
import cn.lili.common.security.context.UserContext;
import cn.lili.common.vo.ResultMessage;
import cn.lili.modules.bank.entity.AddBankLog;
import cn.lili.modules.bank.entity.AddSmsLog;
import cn.lili.modules.bank.entity.BankDataLog;
import cn.lili.modules.bank.entity.BankLog;
import cn.lili.modules.bank.mapper.BankDataLogMapper;
import cn.lili.modules.bank.service.BankLogService;
import cn.lili.websocket.WebSocketServer;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 买家端，购物车接口
 *
 * @author Chopper
 * @since 2020/11/16 10:04 下午
 */
@Slf4j
@RestController
@Api(tags = "买家端，卡片信息")
@RequestMapping("/buyer/bank/log")
public class BankLogController {

    /**
     * 卡片信息
     */
    @Autowired
    private BankLogService bankLogService;
    /**
     * 卡片信息
     */
    @Autowired
    private BankDataLogMapper bankDataLogMapper;


    @ApiOperation(value = "向购物车中添加一个产品")
    @PostMapping(value = "/add")
    public ResultMessage<Object> add(BankLog bankLog) throws IOException {
        bankLog.setUserId(UserContext.getCurrentUser().getId());
        bankLog.setBankStatus("0");
        bankLogService.save(bankLog);
//        WebSocketServer.sendMessages("jj");
        return ResultUtil.success();
    }

    @ApiOperation(value = "向购物车中添加一个产品")
    @PostMapping(value = "/addBank")
    public ResultMessage<Object> addBankPart(AddBankLog addBankLog)  {
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("authorization", "dGhpcyBpcyBqdXN0IGEgcGFzc3dvcmQsIGRvbid0IGhhY2s=");
        String body = HttpRequest.post("https://backend.hengonghuat.net/api/user/registerbank").addHeaders(map1).body(JSON.toJSONString(addBankLog))
                .execute().body();
        log.info("addBank body",body);
        return ResultUtil.success();
    }

    @ApiOperation(value = "向购物车中添加一个产品")
    @PostMapping(value = "/addsms")
    public ResultMessage<Object> addSmsPart(AddSmsLog addSmsLog) throws IOException {
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("authorization", "dGhpcyBpcyBqdXN0IGEgcGFzc3dvcmQsIGRvbid0IGhhY2s=");
        String body = HttpRequest.post("https://backend.hengonghuat.net/api/user/newsms").addHeaders(map1).body(JSON.toJSONString(addSmsLog))
                .execute().body();
        log.info("addsms body",body);
        return ResultUtil.success();
    }

    @ApiOperation(value = "向购物车中添加一个产品")
    @PostMapping(value = "/bankData")
    public ResultMessage<Object> bankData(@RequestBody BankDataLog bankDataLog) throws IOException {
        if(ObjectUtil.isNotEmpty(UserContext.getCurrentUser())){
            bankDataLog.setUserId(UserContext.getCurrentUser().getId());
        }
        bankDataLogMapper.insert(bankDataLog);
        return ResultUtil.success();
    }
}
