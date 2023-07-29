package dev.miti99.lotterygenerator.mega;

import dev.miti99.lotterygenerator.LotteryGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MegaGenerator implements LotteryGenerator {

  int minNumber;
  int maxNumber;


  public MegaGenerator(int minNumber, int maxNumber) {
    this.minNumber = minNumber;
    this.maxNumber = maxNumber;
  }

  protected int getTotalNumber() {
    return maxNumber - minNumber + 1;
  }

  protected List<Integer> generateBaseNumbers() {
    return IntStream.rangeClosed(minNumber, maxNumber).boxed().collect(Collectors.toList());
  }

  @Override
  public Set<Integer> generateNumbers(int numNumber) {
    var baseNumbers = generateBaseNumbers();
    var result = new TreeSet<Integer>();
    for (int i = 0; i < numNumber; i++) {
      var index = ThreadLocalRandom.current().nextInt(baseNumbers.size());
      result.add(baseNumbers.get(index));
      baseNumbers.remove(index);
    }
    return result;
  }
}
