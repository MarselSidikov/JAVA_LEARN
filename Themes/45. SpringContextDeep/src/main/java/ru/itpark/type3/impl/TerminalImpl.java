package ru.itpark.type3.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.itpark.type3.interfaces.Printer;
import ru.itpark.type3.interfaces.Terminal;

@Component
public class TerminalImpl implements Terminal {

  @Value("${terminal.sum}")
  private int money;

  @Autowired
  private Printer printer;

  @Override
  public int getRestOfMoney() {
    return money;
  }

  @Override
  public int giveMoney(int money) {
    this.money = this.money - money;
    printer.print(money);
    return money;
  }
}
