/*
 * Copyright (c) 2024 PT Duta Sarana Inovasi. All rights reserved.
 */

package codes.tamado.udf;

import java.util.Random;

import org.apache.hadoop.hive.ql.exec.UDF;

@SuppressWarnings({"deprecation", "unused"})
public class RandomGreetingsUDF extends UDF {
  public static final String[] greetings = new String[]{
      "Hi",
      "Hello",
      "Good morning",
      "Good day",
      "Good evening",
      "Good night",
      "Good bye",
      "Hasta la vista",
  };

  public String evaluate(final String input) {
    if (input == null) {
      return null;
    }

    final int randomGreetingIndex = new Random().nextInt(greetings.length);
    final String greeting = greetings[randomGreetingIndex];

    return greeting + " " + input;
  }
}
