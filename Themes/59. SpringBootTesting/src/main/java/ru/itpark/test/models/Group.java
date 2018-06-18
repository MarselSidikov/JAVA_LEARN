package ru.itpark.test.models;

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
@Table(name = "service_group")
public class Group {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  @Column(length = 1000)
  private String description;

  @ManyToMany
  @JoinTable(
      name="user_group",
      joinColumns=@JoinColumn(name="group_id", referencedColumnName="id"),
      inverseJoinColumns=@JoinColumn(name="user_id", referencedColumnName="id"))
  private List<User> users;
}
