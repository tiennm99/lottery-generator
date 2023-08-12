package dev.miti99.lotterygenerator.mega;

import org.junit.jupiter.api.Test;

class TopMatchedNumberGeneratorTest {

  @Test
  void generateNumbers() {
    var generator = new TopMatchedNumberGenerator();
    var numbers = generator.generateNumbers(7);
    System.out.println(numbers);
  }

}
