package com.github.tiennm99.lotterygenerator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BaseOnDateLotteryGenerator implements LotteryGenerator {

  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

  /** yyyyMMdd */
  private String date;

  private String getDate() {
    if (date == null) {
      var currentDate = LocalDate.now();
      return currentDate.format(formatter);
    }
    return date;
  }

  public void setDate(String date) {
    try {
      LocalDate.parse(date, formatter);
    } catch (DateTimeParseException e) {
      System.out.println("Input date is not valid.");
      return;
    }
    this.date = date;
  }

  @Override
  public Set<Integer> generateNumbers(int totalNumber, int numNumber) {
    var date = getDate();
    var dateNumber = Integer.parseInt(date);
    var random = new Random(dateNumber);

    var result = new HashSet<Integer>();
    while (result.size() < numNumber) {
      var number = random.nextInt(totalNumber);
      result.add(number);
    }
    return result;
  }
}
