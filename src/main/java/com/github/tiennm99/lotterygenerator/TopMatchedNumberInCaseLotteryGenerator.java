package com.github.tiennm99.lotterygenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TopMatchedNumberInCaseLotteryGenerator implements LotteryGenerator {

  public static final int DEFAULT_RANDOM_TIME = 1_000_000;
  private final int randomTime;
  private final LotteryGenerator generator;

  public TopMatchedNumberInCaseLotteryGenerator(int randomTime, LotteryGenerator generator) {
    this.randomTime = randomTime;
    this.generator = generator;
  }

  public TopMatchedNumberInCaseLotteryGenerator(int randomTime) {
    this(randomTime, new NormalLotteryGenerator());
  }

  public TopMatchedNumberInCaseLotteryGenerator(LotteryGenerator generator) {
    this(DEFAULT_RANDOM_TIME, generator);
  }

  public TopMatchedNumberInCaseLotteryGenerator() {
    this(DEFAULT_RANDOM_TIME);
  }

  @Override
  public Set<Integer> generateNumbers(int totalNumber, int numNumber) {
    Map<Integer, Integer> matchedNumbers = new HashMap<>();
    for (int i = 0; i < randomTime; i++) {
      var numbers = generator.generateNumbers(totalNumber, numNumber);
      for (var number : numbers) {
        matchedNumbers.merge(number, 1, Integer::sum);
      }
    }
    var sortedMatchedNumbers = new TreeMap<Integer, Integer>();
    matchedNumbers.forEach((key, value) -> sortedMatchedNumbers.put(value, key));
    System.out.println(sortedMatchedNumbers);
    return sortedMatchedNumbers.descendingMap().entrySet().stream().limit(numNumber)
        .map(Entry::getValue).collect(Collectors.toSet());
  }
}
