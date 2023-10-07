package com.github.tiennm99.lotterygenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class TopMatchedNumberLotteryGenerator implements LotteryGenerator {

  public static final int DEFAULT_MATCH_TIME = 1_000_000;
  private final int matchTime;

  public TopMatchedNumberLotteryGenerator(int matchTime) {
    this.matchTime = matchTime;
  }

  public TopMatchedNumberLotteryGenerator() {
    this(DEFAULT_MATCH_TIME);
  }

  @Override
  public Set<Integer> generateNumbers(int totalNumber, int numNumber) {
    Map<Integer, Integer> matchedNumbers = new HashMap<>();
    while (true) {
      var number = ThreadLocalRandom.current().nextInt(1, totalNumber + 1);
      matchedNumbers.merge(number, 1, Integer::sum);
      if (matchedNumbers.get(number) == matchTime) {
        break;
      }
    }
    var sortedMatchedNumbers = new TreeMap<Integer, Integer>();
    matchedNumbers.forEach((key, value) -> sortedMatchedNumbers.put(value, key));
    return sortedMatchedNumbers.descendingMap().entrySet().stream().limit(numNumber)
        .map(Entry::getValue)
        .collect(Collectors.toSet());
  }
}
