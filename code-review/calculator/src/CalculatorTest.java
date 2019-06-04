import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CalculatorTest {

  private Calculator calculator = new Calculator();

  @ParameterizedTest
  @CsvSource({
      "2,4,*,8",
      "-1,-8,*,8",
      "-1,0,*,-0",
      "0,0,*,0",
      "1.2,0,*,0",
      "1,0,*,0",
      "8,1,/,8"
  })
  void testcalculate(double num1, double num2, String operator, Double expected) {
    double actuall = calculator.calculate(num1, num2, operator);
    System.out.println(actuall);

    Assertions.assertEquals(actuall, expected);
  }

  @Test
  void testcalculateForInfinity() {
    double actuall = calculator.calculate(4, 0, "/");
    System.out.println(actuall);
    double expected = Double.POSITIVE_INFINITY;

    Assertions.assertEquals(actuall, expected);
  }

  static Stream<Arguments> getArguments() {
    return Stream.of(
        Arguments.of(1, 2, "+", 3.0),
        Arguments.of(-1, -4, "*", 4.0),
        Arguments.of(-1, 0, "*", -0.0),
        Arguments.of(1.2, 0, "*", 0.0),
        Arguments.of(1, 0, "*", 0.0),
        Arguments.of(8, 2, "/", 4.0),
        Arguments.of(1, 1, "-", 0.0),
        Arguments.of(7, 2, "/", 3.5),
        Arguments.of(4, 0, "/", Double.POSITIVE_INFINITY)
    );
  }

  @ParameterizedTest
  @MethodSource("getArguments")
  void calculate(double num1, double num2, String operator, Double expected) {
    double actual = calculator.calculate(num1, num2, operator);
    Assertions.assertEquals(actual, expected);
  }
}