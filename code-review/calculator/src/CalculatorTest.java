import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CalculatorTest {

  private Calculator calculator = new Calculator();


  static Stream<Arguments> getArguments() {
    return Stream.of(
        Arguments.of(1.0, 2.0, "+", 3.0),
        Arguments.of(-1.0, -4.0, "*", 4.0),
        Arguments.of(-1.0, 0.0, "*", -0.0),
        Arguments.of(1.2, 0.0, "*", 0.0),
        Arguments.of(1.0, 0.0, "*", 0.0),
        Arguments.of(8.0, 2.0, "/", 4.0),
        //todo: in this case I had errors, but I dont know how should I solve it.
//        Arguments.of(8.0, 2.0, "$", Double.isNaN()),
        Arguments.of(1.0, 1.0, "-", 0.0),
        Arguments.of(7.0, 2.0, "/", 3.5),
        Arguments.of(0.0, 2.0, "/", 0.0),
        Arguments.of(4.0, 0.0, "/", Double.POSITIVE_INFINITY)
    );
  }

  @ParameterizedTest
  @MethodSource("getArguments")
  void calculate(double num1, double num2, String operator, double expected) {
    double actual = calculator.calculate(num1, num2, operator);
    Assertions.assertEquals(actual, expected);
  }

}