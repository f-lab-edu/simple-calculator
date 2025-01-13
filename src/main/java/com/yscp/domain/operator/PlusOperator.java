package com.yscp.domain.operator;

import com.yscp.domain.Number;

public class PlusOperator implements Operator {

    @Override
    public boolean isMatch(OperatorType operatorType) {
        return OperatorType.PLUS.equals(operatorType);
    }

    @Override
    public Number operate(Number number1, Number number2) {
        return number1.plus(number2);
    }

}
