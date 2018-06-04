package ru.itpark.chat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import ru.itpark.chat.handlers.MessagesHandler;

@EnableWebSocket
@ComponentScan("ru.itpark.chat")
@Configuration
public class WebSocketConfig implements WebSocketConfigurer {

  @Autowired
  private MessagesHandler messagesHandler;


  @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
    webSocketHandlerRegistry.addHandler(messagesHandler, "/handler").setAllowedOrigins("*").withSockJS();
  }
}
