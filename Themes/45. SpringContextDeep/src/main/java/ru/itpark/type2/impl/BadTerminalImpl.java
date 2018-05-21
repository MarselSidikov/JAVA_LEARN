package ru.itpark.type2.impl;

import ru.itpark.type2.interfaces.Terminal;

public class BadTerminalImpl implements Terminal {
  @Override
  public int getRestOfMoney() {
    throw new IllegalArgumentException("=(");
  }

  @Override
  public int giveMoney(int money) {
    throw new IllegalArgumentException("=(");
  }
}
