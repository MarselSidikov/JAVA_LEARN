package ru.itpark.chat.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import ru.itpark.chat.handlers.MessagesHandler;

@SpringBootApplication
@ComponentScan(basePackages = "ru.itpark.chat")
public class ChatWebSocketsApplication {

  public static void main(String[] args) {
    SpringApplication.run(ChatWebSocketsApplication.class, args);
  }
}
