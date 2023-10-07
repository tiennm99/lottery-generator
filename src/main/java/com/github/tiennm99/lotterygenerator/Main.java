package com.github.tiennm99.lotterygenerator;

public class Main {

  public static void main(String[] args) {
    var generator = new TopMatchedNumberInCaseLotteryGenerator();
    var result = generator.generateNumbers(55, 7);
    System.out.println(result);
  }
}
