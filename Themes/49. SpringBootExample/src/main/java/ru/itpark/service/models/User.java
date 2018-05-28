package ru.itpark.service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "service_user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String surname;
  private Integer age;
  private String login;

  @Column(name = "hash_password")
  private String hashPassword;

  @ManyToMany(mappedBy = "users")
  private List<Group> groups;

  @Enumerated(value = EnumType.STRING)
  private UserState state;

  @ElementCollection
  private List<String> authorities;
}
