package com.xiangyun.spring_boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by Administrator on 2017/8/15.
 */
@Configuration
@EnableWebSocketMessageBroker//开启webSocket支持
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    /**
     * 注册STOMP协议的节点，并映射的指定的URL
     * @param stompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/endpointWisely").withSockJS();//注册一个STOMP的endpoint，并指定使用Socketjs

    }

    /**
     * 配置消息代理 （广播式应配置一个/topic代理）
     * @param registry
     */
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }
}
