package com.yscp.domain.operator;

import com.yscp.domain.Number;

import java.util.Objects;

public class ModOperator implements Operator {
    @Override
    public boolean isMatch(OperatorType operatorType) {
        return Objects.equals(OperatorType.MOD, operatorType);
    }

    @Override
    public Number operate(Number number1, Number number2) {
        return number1.mod(number2);
    }
}
