package ru.itpark.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.itpark.service.models.Group;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Builder
public class GroupDto {
  private Long id;
  private String title;

  public static GroupDto from(Group model) {
    return GroupDto.builder()
        .id(model.getId())
        .title(model.getTitle())
        .build();
  }

  public static List<GroupDto> from(List<Group> models) {
    return models
        .stream()
        .map(GroupDto::from)
        .collect(Collectors.toList());
  }
}
