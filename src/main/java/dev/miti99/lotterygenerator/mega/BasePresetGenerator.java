package dev.miti99.lotterygenerator.mega;

import java.util.Set;

public class BasePresetGenerator extends MegaGenerator {

  int numNumber;

  public BasePresetGenerator(int minNumber, int maxNumber, int numNumber) {
    super(minNumber, maxNumber);
    this.numNumber = numNumber;
  }

  public Set<Integer> generateNumbers() {
    return generateNumbers(numNumber);
  }
}
