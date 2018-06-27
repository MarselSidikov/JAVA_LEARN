package ru.itpark.chat.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.chat.models.Chat;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatDto {
    private Long id;
    private String title;
    private String authorName;

    public static ChatDto from(Chat chat) {
        return ChatDto.builder()
                .id(chat.getId())
                .authorName(chat.getCreator().getName())
                .title(chat.getTitle())
                .build();
    }

    public static List<ChatDto> from(List<Chat> chats) {
        return chats.stream().map(ChatDto::from).collect(Collectors.toList());
    }
}
