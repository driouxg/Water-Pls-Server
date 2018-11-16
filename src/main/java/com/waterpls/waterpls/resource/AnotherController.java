package com.waterpls.waterpls.resource;

import java.io.IOException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/hello")
public class AnotherController {

  private Session session;

  @OnOpen
  public void onCreateSession(Session session) {
    this.session = session;
  }

  @OnMessage
  public void onTextMessage(String message) {
    System.out.println("Message: " + message);

    if (session != null && session.isOpen()) {
      try {
        session.getBasicRemote().sendText("From Server!");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
