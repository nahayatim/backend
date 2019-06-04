public class Calculator {

  public double calculate(double num1, double num2, String operator) {
    if (operator.equals("+")) {
      return (num1 + num2);
    }
    if (operator.equals("-")) {
      return num1 - num2;
    }
    if (operator.equals("*")) {
      return num1 * num2;
    }
    if (operator.equals("/")) {
      return num1 / num2;
    }
    throw new IllegalArgumentException("The operator is not supported:" + operator);
  }
}

