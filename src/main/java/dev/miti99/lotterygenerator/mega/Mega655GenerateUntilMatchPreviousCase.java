package dev.miti99.lotterygenerator.mega;

import java.util.HashSet;
import java.util.Set;

public class Mega655GenerateUntilMatchPreviousCase {

  private final Set<Set<Integer>> history = new HashSet<>();

  public static void main(String[] args) {
    var generator = new Mega655GenerateUntilMatchPreviousCase();
    var result = generator.generate();
    System.out.println(result);
  }

  public Set<Integer> generate() {
    history.clear();
    var generator = new Mega655Generator();
    Set<Integer> numbers;
    while (true) {
      numbers = generator.generateNumbers(6);
      System.out.printf("%d. %s\n", history.size(), numbers);
      if (history.contains(numbers)) {
        break;
      }
      history.add(numbers);
    }
    return numbers;
  }
}
