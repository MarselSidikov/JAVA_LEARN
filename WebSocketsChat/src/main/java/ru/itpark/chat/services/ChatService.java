package ru.itpark.chat.services;

import org.springframework.security.core.Authentication;
import ru.itpark.chat.forms.UserForm;
import ru.itpark.chat.transfer.ChatDto;
import ru.itpark.chat.transfer.MessageDto;
import ru.itpark.chat.forms.ChatForm;
import ru.itpark.chat.forms.MessageForm;

import java.util.List;


public interface ChatService {

    List<ChatDto> getChats();

    void addChat(Authentication authentication, ChatForm chat);

    void saveAndDeliverMessage(Authentication authentication, Long chatId, MessageForm message);

    List<MessageDto> getMessages(Authentication authentication, Long chatId);
}
