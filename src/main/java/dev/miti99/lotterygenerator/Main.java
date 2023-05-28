package dev.miti99.lotterygenerator;

import dev.miti99.lotterygenerator.mega.Mega645Generator;

public class Main {

  public static void main(String[] args) {
    var generator = new Mega645Generator();
    var result = generator.generateNumbers(4);
    System.out.println(result);
  }
}
