package ru.itpark.hibernate.demo.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "cars")
@Entity
@Table(name = "owner")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String login;
  @Column(name = "hash_password")
  private String hashPassword;
  private String name;
  private Integer age;
  private Integer friendsCount;
  @OneToMany(mappedBy = "owner")
  List<Car> cars;
}
