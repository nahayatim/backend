public class Calculator {


  public double calculate(double num1, double num2, String operator) {
    if (operator.equals("+")) {
     return Add(num1, num2);
    }
    if (operator.equals("-")) {
      return subtract(num1, num2);
    }
    if (operator.equals("*")) {
     return multiply(num1, num2);
    }
    if (operator.equals("/")) {
      return divide(num1, num2);
    }

    else
      throw new IllegalArgumentException("The operator is not supported."+operator);
  }


  private double divide(double num1, double num2) {
    return (num1 / num2);
  }

  private double multiply(double num1, double num2) {
    return (num1 * num2);
  }

  private double subtract(double num1, double num2) {
    return (num1 - num2);
  }

  private double Add(double num1, double num2) {
    return (num1 + num2);
  }
}
