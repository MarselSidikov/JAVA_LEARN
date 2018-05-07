package ru.itpark.models;

import lombok.*;

import java.util.List;

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
  private List<Car> cars;
}
