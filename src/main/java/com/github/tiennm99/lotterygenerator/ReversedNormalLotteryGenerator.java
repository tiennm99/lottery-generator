package com.github.tiennm99.lotterygenerator;

import java.util.Set;

public class ReversedNormalLotteryGenerator extends NormalLotteryGenerator {

  @Override
  public Set<Integer> generateNumbers(int totalNumber, int numNumber) {
    var baseNumbers = generateBaseNumbers(totalNumber);
    var removedNumbers = super.generateNumbers(totalNumber, totalNumber - numNumber);
    baseNumbers.removeAll(removedNumbers);
    return baseNumbers;
  }
}
