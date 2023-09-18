package com.github.tiennm99.lotterygenerator;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NormalLotteryGenerator implements LotteryGenerator {

  protected Set<Integer> generateBaseNumbers(int totalNumber) {
    return IntStream.rangeClosed(1, totalNumber).boxed().collect(Collectors.toSet());
  }

  @Override
  public Set<Integer> generateNumbers(int totalNumber, int numNumber) {
    var baseNumbers = generateBaseNumbers(totalNumber);
    var result = new TreeSet<Integer>();
    for (int i = 0; i < numNumber; i++) {
      var index = ThreadLocalRandom.current().nextInt(baseNumbers.size());
      var number = baseNumbers.stream().skip(index).findFirst().orElseThrow();
      result.add(number);
      baseNumbers.remove(number);
    }
    return result;
  }
}
