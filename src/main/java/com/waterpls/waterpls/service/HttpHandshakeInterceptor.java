package com.waterpls.waterpls.service;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

public class HttpHandshakeInterceptor implements HandshakeInterceptor {

  @Override
  public boolean beforeHandshake(ServerHttpRequest serverHttpRequest,
      ServerHttpResponse serverHttpResponse,
      WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {

    if (serverHttpRequest instanceof ServletServerHttpRequest) {
      ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) serverHttpRequest;
      HttpSession session = servletRequest.getServletRequest().getSession();
      map.put("sessionId", session.getId());

      System.out.println("Session uri target: " + servletRequest.getURI());
      System.out.println("New Session connected: " + session.getId());
    }
    return true;
  }

  @Override
  public void afterHandshake(org.springframework.http.server.ServerHttpRequest serverHttpRequest,
      org.springframework.http.server.ServerHttpResponse serverHttpResponse,
      WebSocketHandler webSocketHandler, Exception e) {
  }
}
