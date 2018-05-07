package ru.itpark.models;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Car {
  private Integer id;
  private String model;
  private String color;
  private User owner;
}
