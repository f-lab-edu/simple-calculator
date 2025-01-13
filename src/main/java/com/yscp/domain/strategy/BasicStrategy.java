package com.yscp.domain.strategy;

import com.yscp.domain.Calculator;
import com.yscp.domain.Number;
import com.yscp.domain.operator.*;

import java.util.List;

public class BasicStrategy implements CalculatorStrategy {
    private static final Calculator calculators;

    public BasicStrategy() {
    }

    static {
        List<Operator> operators = List.of(new PlusOperator(),
                new MinusOperator(),
                new MultiplyOperator(),
                new ModOperator());

        calculators = new Calculator(operators);
    }


    @Override
    public Number calculate(String input) {
        String[] splitString = splitGap(input);

        Number[] numbers = numberSplit(splitString);

        OperatorType[] operatorString = operatorSplit(splitString);
        int operatorSize = operatorString.length;

        Number result = calculators.calculate(numbers[0], operatorString[0], numbers[1]);

        for (int i = 1; i < operatorSize; i++) {
            if (i + 1 < operatorSize &&
                    (operatorString[i].isPlusOrMinus()) &&
                    (operatorString[i + 1].isMultiplyOrMod())) {
                numbers[i + 1] = calculators.calculate(numbers[i + 1], operatorString[i + 1], numbers[i + 2]);
                numbers[i + 2] = new Number(1);
            }

            result = calculators.calculate(result, operatorString[i], numbers[i + 1]);
        }

        return result;
    }

    private OperatorType[] operatorSplit(String[] splitString) {
        int size = (splitString.length / 2);
        OperatorType[] operatorSplit = new OperatorType[size];

        int temp = 0;

        for (int i = 1; temp < size; i += 2) {
            operatorSplit[temp] = OperatorType.from(splitString[i]);
            temp += 1;
        }

        return operatorSplit;
    }

    private Number[] numberSplit(String[] splitString) {
        int size = (splitString.length / 2) + 1;
        Number[] numberStrings = new Number[size];
        for (int i = 0; i < size; i++) {
            numberStrings[i] = new Number(splitString[2 * i]);
        }

        return numberStrings;
    }

    private String[] splitGap(String input) {
        return input.split(" ");
    }
}
