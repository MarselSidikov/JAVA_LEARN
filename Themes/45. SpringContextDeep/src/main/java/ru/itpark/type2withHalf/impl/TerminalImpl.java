package ru.itpark.type2withHalf.impl;

import ru.itpark.type2withHalf.interfaces.Printer;
import ru.itpark.type2withHalf.interfaces.Terminal;

public class TerminalImpl implements Terminal {

  private int money;

  private Printer printer;

  public TerminalImpl(Printer printer,int money) {
    this.money = money;
    this.printer = printer;
  }

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
