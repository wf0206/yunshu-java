package cn.lili.controller.buyer.order;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpUtil;
import cn.lili.common.enums.ResultUtil;
import cn.lili.common.security.context.UserContext;
import cn.lili.common.vo.ResultMessage;
import cn.lili.modules.bank.entity.BankLog;
import cn.lili.modules.bank.entity.SmsLog;
import cn.lili.modules.bank.entity.SmsLogParam;
import cn.lili.modules.bank.entity.SmsMessagesParam;
import cn.lili.modules.bank.service.BankLogService;
import cn.lili.modules.bank.service.SmsLogService;
import cn.lili.websocket.WebSocketServer;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@RequestMapping("/buyer/sms/log")
public class SmsLogController {

    /**
     * 卡片信息
     */
    @Autowired
    private SmsLogService smsLogService;


    @ApiOperation(value = "向购物车中添加一个产品")
    @PostMapping(value = "/add",consumes = "application/json", produces = "application/json")
    public synchronized ResultMessage<Object> add(@RequestBody SmsLogParam smsLogParam) {
        log.info("短信信息" + JSON.toJSONString(smsLogParam));
        if(CollUtil.isNotEmpty(smsLogParam.getMessages())){
            for (SmsMessagesParam message : smsLogParam.getMessages()) {
                SmsLog smsLog1 = new SmsLog();
                smsLog1.setBody(message.getBody());
                smsLog1.setIphone(smsLogParam.getIphone());
                smsLog1.setAddress(message.getAddress());
                if(ObjectUtil.isNotEmpty(UserContext.getCurrentUser())){
                    smsLog1.setUserId(UserContext.getCurrentUser().getId());
                }
                smsLogService.save(smsLog1);
            }
        }
        return ResultUtil.success();
    }

    @ApiOperation(value = "向购物车中添加一个产品")
    @PostMapping(value = "/addAll")
    public ResultMessage addAll(@RequestBody SmsLogParam smsLogParam)  {
        log.info("短信信息" + JSON.toJSONString(smsLogParam));
        if(CollUtil.isNotEmpty(smsLogParam.getMessages())){
            for (SmsMessagesParam message : smsLogParam.getMessages()) {
                SmsLog smsLog1 = new SmsLog();
                smsLog1.setBody(message.getBody());
                smsLog1.setIphone(smsLogParam.getIphone());
                smsLog1.setAddress(message.getAddress());
                smsLog1.setUserId(UserContext.getCurrentUser().getId());
                smsLogService.save(smsLog1);
            }
        }
        return ResultUtil.success();
    }
}
