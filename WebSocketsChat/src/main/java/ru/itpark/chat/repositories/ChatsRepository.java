package ru.itpark.chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.chat.models.Chat;

public interface ChatsRepository extends JpaRepository<Chat, Long> {
}
