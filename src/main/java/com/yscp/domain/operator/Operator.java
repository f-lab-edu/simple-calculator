package com.yscp.domain.operator;

import com.yscp.domain.Number;

public interface Operator {
    boolean isMatch(OperatorType operatorType);

    Number operate(Number number1, Number number2);
}
