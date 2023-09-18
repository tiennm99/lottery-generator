package com.github.tiennm99.lotterygenerator;

public class Main {

  public static void main(String[] args) {
    var generator = new NormalLotteryGenerator();
    var result = generator.generateNumbers(45, 6);
    System.out.println(result);
  }
}
