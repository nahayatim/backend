package at.nacs.ex5thecalculator.controller;

import at.nacs.ex5thecalculator.controller.operation.Operation;
import at.nacs.ex5thecalculator.model.Expression;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Calculator {

  private final List<Operation> operations;

  public double calculate(Expression expression) throws IllegalArgumentException {
    return operations.stream()
                     .filter(operation -> operation.matches(expression))
                     .map(operation -> operation.apply(expression))
                     .findFirst()
                     .orElseThrow(IllegalArgumentException::new);
  }
}

