package at.nacs.ex5thecalculator;

import jdk.dynalink.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.beans.Expression;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class Calculator {

  private final Set<Operation>operations;

//  public double calculate(Expression expression){
//
//  }
}
