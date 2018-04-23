package ru.itpark;

import java.util.Comparator;

public class HumansByHeightComparator implements Comparator<Human> {
  @Override
  public int compare(Human o1, Human o2) {
    return o1.getHeight() - o2.getHeight();
  }
}
