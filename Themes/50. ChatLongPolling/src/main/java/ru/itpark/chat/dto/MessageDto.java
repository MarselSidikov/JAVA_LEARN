package ru.itpark.chat.dto;

import lombok.Data;

@Data
public class MessageDto {
  private String text;
  private String from;
}
