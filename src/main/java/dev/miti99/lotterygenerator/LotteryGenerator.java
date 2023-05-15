package dev.miti99.lotterygenerator;

import java.util.List;

public interface LotteryGenerator {
    List<Integer> generateNumbers();
    List<Integer> generateNumbers(int numNumber);
}
