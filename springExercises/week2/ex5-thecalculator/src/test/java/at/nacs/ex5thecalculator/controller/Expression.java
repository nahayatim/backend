package at.nacs.ex5thecalculator.controller;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.beans.Expression;
import java.util.Arrays;
import java.util.List;

@Data
@Component
@Builder
public class Expressions {
    private  Double number1;
    private  Double number2;
    private  String symbol;

    public Expression from(String input) {
        String[] splited = input.split(" ");
        List<String> expressions = Arrays.asList(splited);




    }
}
