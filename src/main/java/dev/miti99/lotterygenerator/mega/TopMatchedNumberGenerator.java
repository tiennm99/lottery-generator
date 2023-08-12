package dev.miti99.lotterygenerator.mega;

import dev.miti99.lotterygenerator.LotteryGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class TopMatchedNumberGenerator implements LotteryGenerator {

  @Override
  public Set<Integer> generateNumbers(int numNumber) {
    Map<Integer, Integer> matchedNumbers = new HashMap<>();
    while (true) {
      var number = ThreadLocalRandom.current().nextInt(1, 56);
      matchedNumbers.merge(number, 1, Integer::sum);
      if (matchedNumbers.get(number) == 1_000_000_000) {
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
