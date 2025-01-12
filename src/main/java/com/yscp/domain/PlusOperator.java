package com.yscp.domain;

public class PlusOperator implements Operator {

    @Override
    public Integer operate(Integer number1, Integer number2) {
        if (number1 == null || number2 == null) {
            throw new IllegalArgumentException("Null numbers not allowed");
        }

        return number1 + number2;
    }
}
