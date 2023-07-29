package dev.miti99.lotterygenerator;

import dev.miti99.lotterygenerator.mega.Mega655Generator;

public class Main {

  public static void main(String[] args) {
    var generator = new Mega655Generator();
    var result = generator.generateNumbers(7);
    System.out.println(result);
  }
}
