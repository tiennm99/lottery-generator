package com.github.tiennm99.lotterygenerator;

import java.util.Set;

public interface LotteryGenerator {

  Set<Integer> generateNumbers(int totalNumber, int numNumber);
}
