package ru.itpark.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.service.models.Group;

public interface GroupsRepository extends JpaRepository<Group, Long> {

}
