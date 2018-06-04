package ru.itpark.chat.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessagesHandler extends TextWebSocketHandler {

  private List<WebSocketSession> sessions = new ArrayList<>();

  private Logger logger = LoggerFactory.getLogger(MessagesHandler.class);

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    logger.info("Connected from client " + session.getRemoteAddress());
    sessions.add(session);
  }

  @Override
  protected void handleTextMessage(WebSocketSession userSession, TextMessage message) throws Exception {
    for (WebSocketSession session : sessions) {
      if (session.isOpen()) {
        session.sendMessage(new TextMessage(message.getPayload()));
      }
    }
  }
}
