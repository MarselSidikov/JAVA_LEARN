package ru.itpark.chat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.itpark.chat.forms.UserForm;
import ru.itpark.chat.transfer.MessageDto;
import ru.itpark.chat.forms.ChatForm;
import ru.itpark.chat.transfer.ChatDto;
import ru.itpark.chat.forms.MessageForm;
import ru.itpark.chat.services.ChatService;

import java.util.List;

@RestController
public class ChatsController {

    @Autowired
    private ChatService chatService;

    @PreAuthorize(value = "hasAuthority('CAN_CREATE_CHAT')")
    @GetMapping("/chats")
    public ResponseEntity<List<ChatDto>> getChats() {
        return ResponseEntity.ok(chatService.getChats());
    }

    @PreAuthorize(value = "hasAuthority('CAN_CREATE_CHAT')")
    @PostMapping("/chats")
    public ResponseEntity postChat(@RequestBody ChatForm chat, Authentication authentication) {
        chatService.addChat(authentication, chat);
        return ResponseEntity.accepted().build();
    }

    @PreAuthorize(value = "hasAuthority('CAN_SEND_AND_GET_MESSAGES')")
    @PostMapping("/chats/{chat-id}/messages")
    public ResponseEntity postMessage(@RequestBody MessageForm message,
                                              @PathVariable("chat-id") Long chatId,
                                              Authentication authentication) {
        chatService.saveAndDeliverMessage(authentication, chatId, message);
        return ResponseEntity.accepted().build();
    }

    @PreAuthorize(value = "hasAuthority('CAN_SEND_AND_GET_MESSAGES')")
    @GetMapping("chats/{chat-id}/messages")
    public ResponseEntity<List<MessageDto>> getMessages(
            @PathVariable("chat-id") Long chatId, Authentication authentication) {
        return ResponseEntity.ok(chatService.getMessages(authentication, chatId));
    }
}
