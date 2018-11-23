package com.waterpls.waterpls.controller;

import com.waterpls.waterpls.domain.User;
import com.waterpls.waterpls.domain.UserResponse;
import com.waterpls.waterpls.domain.entity.Username;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

// https://spring.io/guides/gs/messaging-stomp-websocket/
@Controller
public class UserController {

  @Autowired
  SessionFactory sessionFactory;

  @MessageMapping("/user")
  @SendTo("/topic/user")
  public UserResponse getUser(User user) {
    System.out.println("Reached User!");

    Session session = sessionFactory.openSession();

    // Try to use Hibernate to store items in the database
    Transaction transaction = session.beginTransaction();

    Username username = new Username();
    username.setId(1);
    username.setUsername("DryOx");

    session.persist(username);
    transaction.commit();




    CriteriaBuilder builder = session.getCriteriaBuilder();

    CriteriaQuery<Username> query = builder.createQuery(Username.class);

    Root<Username> root = query.from(Username.class);

    query.select(root);

    Query<Username> q = session.createQuery(query);

    List<Username> list = q.getResultList();

    System.out.println("PRINTING " + list.size() + " USERNAMES FROM DATABASE!");
    for (Username l : list) {
      System.out.println("" + l.getUsername());
    }

    session.close();

    return new UserResponse("Hi " + user.getName());
  }

  @MessageMapping("/ping")
  public String ping(String string) {
    System.out.println("PING!!!!");
    return "wow";
  }

  @MessageMapping("/ping1")
  @SendTo("/the/pinger")
  public String ping() {
    System.out.println("POOOOOOOOONG!!!");
    return "wow";
  }
}
