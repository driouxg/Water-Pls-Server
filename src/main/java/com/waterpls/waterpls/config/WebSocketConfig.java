package com.waterpls.waterpls.config;

import com.waterpls.waterpls.service.HttpHandshakeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  @Override
  public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
    System.out.println("Printing because I can");
    stompEndpointRegistry.addEndpoint("/websocket-example")
        .addInterceptors(new HttpHandshakeInterceptor())
        .setAllowedOrigins("*").withSockJS();

    stompEndpointRegistry.addEndpoint("/ping").addInterceptors(new HttpHandshakeInterceptor())
        .setAllowedOrigins("*");
    stompEndpointRegistry.addEndpoint("/ping1").addInterceptors(new HttpHandshakeInterceptor())
        .setAllowedOrigins("*");
    //stompEndpointRegistry.addEndpoint("/chat").addInterceptors(new HttpHandshakeInterceptor())
    //    .setAllowedOrigins("*");
    stompEndpointRegistry.addEndpoint("/user").addInterceptors(new HttpHandshakeInterceptor())
        .setAllowedOrigins("*").withSockJS();
  }

  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry.enableSimpleBroker("/topic");
    registry.setApplicationDestinationPrefixes("/app");
  }
}
