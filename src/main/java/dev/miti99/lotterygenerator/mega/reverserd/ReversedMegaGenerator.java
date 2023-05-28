package dev.miti99.lotterygenerator.mega.reverserd;

import dev.miti99.lotterygenerator.mega.BasePresetGenerator;
import java.util.List;

public class ReversedMegaGenerator extends BasePresetGenerator {

  public ReversedMegaGenerator(int minNumber, int maxNumber, int numNumber) {
    super(minNumber, maxNumber, numNumber);
  }

  @Override
  public List<Integer> generateNumbers(int numNumber) {
    var baseNumbers = generateBaseNumbers();
    var removedNumbers = super.generateNumbers(getTotalNumber() - numNumber);
    return baseNumbers.stream().filter(n -> !removedNumbers.contains(n)).toList();
  }
}
