package ru.itpark.chat.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itpark.chat.models.Message;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDto {
    private Long chatId;
    private String from;
    private String message;

    public static MessageDto from(Message message) {
        return MessageDto.builder()
                .chatId(message.getChat().getId())
                .message(message.getText())
                .from(message.getAuthor().getName())
                .build();
    }

    public static List<MessageDto> from(List<Message> messages) {
        return messages.stream().map(MessageDto::from).collect(Collectors.toList());
    }
}
