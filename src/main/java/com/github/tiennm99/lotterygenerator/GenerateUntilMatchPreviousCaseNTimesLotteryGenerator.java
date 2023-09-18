package com.github.tiennm99.lotterygenerator;

import java.util.HashMap;
import java.util.Set;

public class GenerateUntilMatchPreviousCaseNTimesLotteryGenerator extends NormalLotteryGenerator {

  public static final int DEFAULT_MATCH_TIME = 3;
  private final int matchTime;

  public GenerateUntilMatchPreviousCaseNTimesLotteryGenerator(int matchTime) {
    this.matchTime = matchTime;
  }

  public GenerateUntilMatchPreviousCaseNTimesLotteryGenerator() {
    this(DEFAULT_MATCH_TIME);
  }

  @Override
  public Set<Integer> generateNumbers(int totalNumber, int numNumber) {
    var history = new HashMap<Set<Integer>, Integer>();
    Set<Integer> numbers;
    int count = 0;
    while (true) {
      numbers = super.generateNumbers(totalNumber, numNumber);
      var times = history.merge(numbers, 1, Integer::sum);
      System.out.printf("%d. %s %d\n", count, numbers, times);
      if (times == matchTime) {
        break;
      }
      count++;
    }
    return numbers;
  }
}
