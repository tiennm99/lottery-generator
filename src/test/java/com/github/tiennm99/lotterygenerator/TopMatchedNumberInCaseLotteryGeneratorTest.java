package com.github.tiennm99.lotterygenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TopMatchedNumberInCaseLotteryGeneratorTest {

  @Test
  void testMega645() {
    var generator = new TopMatchedNumberInCaseLotteryGenerator();
    var numbers = generator.generateNumbers(45, 6);
    System.out.println(numbers);
    assertEquals(6, numbers.size());
    for (int number : numbers) {
      assertTrue(number >= 1 && number <= 45);
    }
  }

  @Test
  void testMega655() {
    var generator = new TopMatchedNumberInCaseLotteryGenerator();
    var numbers = generator.generateNumbers(55, 6);
    System.out.println(numbers);
    assertEquals(6, numbers.size());
    for (int number : numbers) {
      assertTrue(number >= 1 && number <= 55);
    }
  }
}
