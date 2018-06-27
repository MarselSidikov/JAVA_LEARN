package ru.itpark.chat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.chat.models.Chat;
import ru.itpark.chat.models.Message;

import java.util.List;

public interface MessagesRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByChat(Chat chat);
}
