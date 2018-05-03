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
  private String name;
  private Integer age;
  private Double height;
}
