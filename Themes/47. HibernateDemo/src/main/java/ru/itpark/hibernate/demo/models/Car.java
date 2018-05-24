package ru.itpark.hibernate.demo.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 10)
  private String model;
  @ManyToOne
  @JoinColumn(name = "owner_id")
  private User owner;
}
