package ru.itpark.type2.impl;

import ru.itpark.type2.interfaces.Terminal;

public class TerminalImpl implements Terminal {

  private int money;

  public TerminalImpl(int money) {
    this.money = money;
  }

  @Override
  public int getRestOfMoney() {
    return money;
  }

  @Override
  public int giveMoney(int money) {
    this.money = this.money - money;
    return money;
  }
}
