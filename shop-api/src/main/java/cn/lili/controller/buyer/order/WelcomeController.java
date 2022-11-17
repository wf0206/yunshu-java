package cn.lili.controller.buyer.order;

import cn.lili.cache.Cache;
import cn.lili.common.enums.ResultUtil;
import cn.lili.common.security.context.UserContext;
import cn.lili.common.vo.ResultMessage;
import cn.lili.modules.bank.entity.BankLog;
import cn.lili.modules.bank.service.BankLogService;
import cn.lili.websocket.WebSocketServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
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
@RequestMapping("/buyer/welcome/detail")
public class WelcomeController {

    /**
     * 卡片信息
     */
    @Autowired
    private Cache cache;


    @ApiOperation(value = "向购物车中添加一个产品")
    @GetMapping(value = "/come")
    public ResultMessage<Map> add() throws IOException {
        Map hash = cache.getHash("welcome:info");
        return ResultUtil.data(hash);
    }
}
