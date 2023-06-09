package dev.miti99.lotterygenerator.mega;

import dev.miti99.lotterygenerator.LotteryGenerator;
import java.util.ArrayList;
import java.util.List;
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
  public List<Integer> generateNumbers(int numNumber) {
    var baseNumbers = generateBaseNumbers();
    var result = new ArrayList<Integer>(numNumber);
    for (int i = 0; i < numNumber; i++) {
      var index = (int) (Math.random() * baseNumbers.size());
      result.add(baseNumbers.get(index));
      baseNumbers.remove(index);
    }
    return result;
  }
}
