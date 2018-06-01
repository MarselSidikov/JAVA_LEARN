package ru.itpark.chat.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itpark.chat.dto.MessageDto;
import ru.itpark.chat.dto.UserDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ChatController {

  private Map<String, List<MessageDto>> messages =
      new HashMap<>();

  @PostMapping("/users")
  public ResponseEntity<Object> enterChat(@RequestBody UserDto user) {
    messages.put(user.getName(), new ArrayList<>());
    return ResponseEntity.ok().build();
  }

  @PostMapping("/messages")
  public ResponseEntity<Object> sendMessage(@RequestBody MessageDto message) {
    for (String name : messages.keySet()) {
      messages.get(name).add(message);
    }
    return ResponseEntity.accepted().build();
  }

  @GetMapping("/messages/{user-name}")
  public List<MessageDto> getMessages(@PathVariable("user-name") String userName) {
    while (true) {
      if (!messages.get(userName).isEmpty()) {
        List<MessageDto> result = new ArrayList<>(messages.get(userName));
        messages.get(userName).clear();
        return result;
      }
    }
  }
}
