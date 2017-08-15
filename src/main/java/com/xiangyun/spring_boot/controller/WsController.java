package com.xiangyun.spring_boot.controller;

import com.xiangyun.spring_boot.bean.XiangYunMessage;
import com.xiangyun.spring_boot.bean.XiangYunResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2017/8/15.
 */
@Controller
public class WsController {
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public XiangYunResponse say(XiangYunMessage xiangYunMessage) throws Exception {
        Thread.sleep(3000);
        return new XiangYunResponse("Welcome, "+xiangYunMessage.getName()+"!");
    }
}
