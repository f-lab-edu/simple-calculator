package com.yscp.domain.operator;

import com.yscp.domain.Number;

import java.util.Objects;

public class MinusOperator implements Operator {
    @Override
    public boolean isMatch(OperatorType operatorType) {
        return Objects.equals(OperatorType.MINUS, operatorType);
    }


    @Override
    public Number operate(Number number1, Number number2) {
        return number1.minus(number2);
    }
}
