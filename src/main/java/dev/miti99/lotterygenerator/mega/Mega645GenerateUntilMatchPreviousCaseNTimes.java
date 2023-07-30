package dev.miti99.lotterygenerator.mega;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Mega645GenerateUntilMatchPreviousCaseNTimes {

  private final Map<Set<Integer>, Integer> history = new HashMap<>();

  public static void main(String[] args) {
    var generator = new Mega645GenerateUntilMatchPreviousCaseNTimes();
    var result = generator.generate();
    System.out.println(result);
  }

  public Set<Integer> generate() {
    history.clear();
    var generator = new Mega645Generator();
    Set<Integer> numbers;
    int count = 0;
    while (true) {
      numbers = generator.generateNumbers(6);
      var times = history.merge(numbers, 1, Integer::sum);
      System.out.printf("%d. %s %d\n", count, numbers, times);
      if (times == 3) {
        break;
      }
      count++;
    }
    return numbers;
  }
}
