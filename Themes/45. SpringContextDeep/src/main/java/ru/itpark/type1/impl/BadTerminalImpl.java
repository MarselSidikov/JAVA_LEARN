package ru.itpark.type1.impl;

import ru.itpark.type1.interfaces.Terminal;

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
