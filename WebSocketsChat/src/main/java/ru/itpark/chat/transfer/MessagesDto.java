package ru.itpark.chat.transfer;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessagesDto {

    private List<MessageDto> messages;

    public MessagesDto() {
    }

    public List<MessageDto> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDto> messages) {
        this.messages = messages;
    }

    public String toString() {
        return messages.toString();
    }
}
