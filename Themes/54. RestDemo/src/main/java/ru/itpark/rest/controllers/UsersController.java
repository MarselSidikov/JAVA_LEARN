package ru.itpark.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itpark.rest.dto.GroupDto;
import ru.itpark.rest.dto.UserDto;
import ru.itpark.rest.services.UsersService;

import java.util.List;

@RestController
public class UsersController {

  @Autowired
  private UsersService service;

  @GetMapping("/users")
  public ResponseEntity<List<UserDto>> getAllUsers() {
    return ResponseEntity.ok(service.getAllUsers());
  }

  @GetMapping("/users/{user-id}/groups")
  public ResponseEntity<List<GroupDto>> getAllUsers(@PathVariable("user-id") Long userId) {
    return ResponseEntity.ok(service.getGroupOfUser(userId));
  }
}
