package ru.itpark;

public class MessagePrinterStandardImpl implements MessagePrinter {

  private Message message;

  public MessagePrinterStandardImpl(Message message) {
    this.message = message;
  }

  public void print() {
    System.out.println(message.getText());
  }
}
