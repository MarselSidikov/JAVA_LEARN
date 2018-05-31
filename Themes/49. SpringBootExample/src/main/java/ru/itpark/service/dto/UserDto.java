package ru.itpark.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.service.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
  private Long id;
  private String login;
  private String state;
  private String name;

  public static UserDto from(User model) {
    return UserDto.builder()
        .id(model.getId())
        .name(model.getName())
        .build();
  }

  public static List<UserDto> from(List<User> models) {
    return models.stream().map(UserDto::from).collect(Collectors.toList());
  }
}
