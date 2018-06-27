package ru.itpark.chat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.itpark.chat.forms.ChatForm;
import ru.itpark.chat.forms.MessageForm;
import ru.itpark.chat.models.Chat;
import ru.itpark.chat.models.Message;
import ru.itpark.chat.models.User;
import ru.itpark.chat.repositories.ChatsRepository;
import ru.itpark.chat.repositories.MessagesRepository;
import ru.itpark.chat.transfer.ChatDto;
import ru.itpark.chat.transfer.MessageDto;

import java.util.List;

import static ru.itpark.chat.transfer.ChatDto.from;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private MessagesRepository messagesRepository;

    @Autowired
    private ChatsRepository chatsRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Override
    public List<MessageDto> getMessages(Authentication authentication, Long chatId) {
        Chat chat = chatsRepository.findOne(chatId);
        List<Message> messages = messagesRepository.findAllByChat(chat);
        return MessageDto.from(messages);

    }

    @Override
    public void saveAndDeliverMessage(Authentication authentication, Long chatId, MessageForm message) {
        User currentUser = authenticationService.getUserByAuthentication(authentication);
        Chat chat = chatsRepository.findOne(chatId);
        Message model = Message.builder()
                .chat(chat)
                .author(currentUser)
                .text(message.getText())
                .build();
        messagesRepository.save(model);
        messagingTemplate.convertAndSend("/topic/chats/" + chatId, MessageDto.from(model));
    }

    @Override
    public void addChat(Authentication authentication, ChatForm chatForm) {
        User creator = authenticationService.getUserByAuthentication(authentication);
        Chat chat = Chat.builder()
                .creator(creator)
                .title(chatForm.getTitle())
                .build();
        chatsRepository.save(chat);
    }

    @Override
    public List<ChatDto> getChats() {
        return from(chatsRepository.findAll());
    }
}
