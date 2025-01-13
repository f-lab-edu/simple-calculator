package com.yscp.domain;

import com.yscp.domain.operator.Operator;
import com.yscp.domain.operator.OperatorType;

import java.util.List;

public class Calculators {
    private List<Operator> operators;

    public Calculators(List<Operator> operators) {
        this.operators = operators;
    }


    public Number calculate(Number number1, OperatorType operatorType, Number number2) {
        return findByOperatorType(operatorType)
                .operate(number1, number2);
    }

    private Operator findByOperatorType(OperatorType operatorType) {
        return operators.stream()
                .filter(operator -> operator.isMatch(operatorType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("invalid operator type: " + operatorType));
    }
}
