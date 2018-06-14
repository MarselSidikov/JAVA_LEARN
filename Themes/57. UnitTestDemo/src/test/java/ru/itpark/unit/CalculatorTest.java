package ru.itpark.unit;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
  private Calculator testingCalculator = new Calculator();

  @Test
  public void testSum() {
    int actual = testingCalculator.sum(5,6);
    int expected = 11;
    assertEquals(expected, actual);
  }

  @Test
  public void testIsPrimaryOn6() {
    boolean result = testingCalculator.isPrimary(6);
    assertFalse(result);
  }

  @Test
  public void testIsPrimaryOn7() {
    boolean result = testingCalculator.isPrimary(7);
    assertTrue(result);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIsPrimaryOn0() {
    testingCalculator.isPrimary(0);
  }

}