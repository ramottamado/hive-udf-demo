package codes.tamado.hive.udf;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomGreetingsUDFTest {
  List<String> greetings;
  RandomGreetingsUDF udf;

  @BeforeEach
  void setUp() {
    udf = new RandomGreetingsUDF();

    greetings = Arrays.stream(RandomGreetingsUDF.greetings)
        .map(x -> x + " Tamado")
        .collect(Collectors.toList());
  }

  @Test
  void evaluate() {
    final String result = udf.evaluate("Tamado");

    Assertions.assertTrue(greetings.contains(result));
  }
}