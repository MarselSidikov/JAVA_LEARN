package ru.itpark.models;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
  private Integer id;
  private String login;
  private String hashPassword;
  private String name;
}
