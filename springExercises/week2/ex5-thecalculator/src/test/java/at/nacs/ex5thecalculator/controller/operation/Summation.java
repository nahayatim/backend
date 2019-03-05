package at.nacs.ex5thecalculator.controller.operation;

import java.beans.Expression;

public class Addition implements Operation {
    @Override
    public Double apply(Expression expression) {
        return null;
    }

    @Override
    public boolean matches(Expression expression) {
        return false;
    }
}
