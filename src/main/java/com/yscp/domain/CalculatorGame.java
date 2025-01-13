package com.yscp.domain;

import com.yscp.domain.strategy.CalculatorStrategy;

public class CalculatorGame {
    private final CalculatorStrategy calculatorStrategy;

    public CalculatorGame(CalculatorStrategy calculatorStrategy) {
        this.calculatorStrategy = calculatorStrategy;
    }

    public Number calculate(String input) {
        return calculatorStrategy.calculate(input);
    }
}
