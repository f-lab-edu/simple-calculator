package com.yscp.domain.operator;

import com.yscp.domain.Number;

import java.util.Objects;

public class MultiplyOperator implements Operator {
    @Override
    public boolean isMatch(OperatorType operatorType) {
        return Objects.equals(OperatorType.MULTIPLY, operatorType);
    }

    @Override
    public Number operate(Number number1, Number number2) {
        return number1.multiply(number2);
    }
}
