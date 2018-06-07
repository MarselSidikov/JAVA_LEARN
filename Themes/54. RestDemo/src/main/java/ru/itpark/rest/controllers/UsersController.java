package ru.itpark.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itpark.rest.dto.GroupDto;
import ru.itpark.rest.dto.TokenDto;
import ru.itpark.rest.dto.UserDto;
import ru.itpark.rest.forms.LoginPasswordForm;
import ru.itpark.rest.services.UsersService;

import java.util.List;

@RestController
public class UsersController {

  @Autowired
  private UsersService service;

  @PostMapping("/login")
  public ResponseEntity<TokenDto> login(@RequestBody LoginPasswordForm form) {
    TokenDto token = service.login(form);
    return ResponseEntity.ok(token);
  }

  @PreAuthorize("hasAuthority('CAN_VIEW_USERS')")
  @GetMapping("/users")
  public ResponseEntity<List<UserDto>> getAllUsers() {
    return ResponseEntity.ok(service.getAllUsers());
  }

  @PreAuthorize("hasAuthority('CAN_VIEW_GROUPS ')")
  @GetMapping("/users/{user-id}/groups")
  public ResponseEntity<List<GroupDto>> getAllUsers(@PathVariable("user-id") Long userId) {
    return ResponseEntity.ok(service.getGroupOfUser(userId));
  }
}
