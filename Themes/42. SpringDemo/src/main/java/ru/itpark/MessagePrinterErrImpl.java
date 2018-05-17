package ru.itpark;

public class MessagePrinterErrImpl implements MessagePrinter {

  private Message message;

  public MessagePrinterErrImpl(Message message) {
    this.message = message;
  }

  public void print() {
    System.err.println(message.getText());
  }
}
