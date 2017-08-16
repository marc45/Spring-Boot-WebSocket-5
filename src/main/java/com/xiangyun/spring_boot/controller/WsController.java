package com.xiangyun.spring_boot.controller;

import com.xiangyun.spring_boot.bean.XiangYunMessage;
import com.xiangyun.spring_boot.bean.XiangYunResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Created by Administrator on 2017/8/15.
 */
@Controller
public class WsController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;//向浏览器发送消息
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public XiangYunResponse say(XiangYunMessage xiangYunMessage) throws Exception {
        Thread.sleep(3000);
        return new XiangYunResponse("Welcome, "+xiangYunMessage.getName()+"!");
    }

    /**
     * 处理聊天消息的controller
     */
    @MessageMapping("/chat")
    public void handleChat(Principal principal,String msg){
        if(principal.getName().equals("问亚兵")){
            simpMessagingTemplate.convertAndSendToUser("薛征","/queue/notifications",principal.getName()+"发送的消息："+msg);
        }else{
            simpMessagingTemplate.convertAndSendToUser("问亚兵","/queue/notifications",principal.getName()+"发送的消息："+msg);
        }

    }
}
