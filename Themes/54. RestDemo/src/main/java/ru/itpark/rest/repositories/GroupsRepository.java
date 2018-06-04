package ru.itpark.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.rest.models.Group;

public interface GroupsRepository extends JpaRepository<Group, Long> {

}
