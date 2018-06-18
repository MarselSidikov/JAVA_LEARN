package ru.itpark.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.test.models.Group;

public interface GroupsRepository extends JpaRepository<Group, Long> {

}
