package ru.itpark.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itpark.service.dto.UserDto;
import ru.itpark.service.services.GroupsService;
import ru.itpark.service.services.GroupsServiceImpl;

import java.util.List;

@Controller
public class GroupsController {

  @Autowired
  private GroupsService service;

  @GetMapping("/groups")
  public String getGroupsPage(ModelMap model) {
    model.addAttribute("groups", service.getGroups());
    return "GroupsPage";
  }

  @GetMapping("/groups/{group-id}/users")
  @ResponseBody
  public ResponseEntity<List<UserDto>>
  getUsersOfGroup(@PathVariable("group-id") Long groupId) {
    return ResponseEntity.ok(service.getUsersOfGroup(groupId));
  }
}
