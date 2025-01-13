package com.yscp.domain.operator;

import com.yscp.domain.Calculators;
import com.yscp.domain.Number;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculators")
class CalculatorsTest {

    private Calculators calculators;

    @BeforeEach
    void setUp() {
        List<Operator> operators = List.of(new PlusOperator(),
                new MinusOperator(),
                new MultiplyOperator(),
                new ModOperator());
        calculators = new Calculators(operators);
    }

    public static Stream<Arguments> validRequest() {
        return Stream.of(Arguments.of(new Number(1), OperatorType.from("+"), new Number(2), new Number(3)),
                Arguments.of(new Number(1), OperatorType.from("-"), new Number(2), new Number(-1)),
                Arguments.of(new Number(1), OperatorType.from("*"), new Number(2), new Number(2)),
                Arguments.of(new Number(1), OperatorType.from("/"), new Number(2), new Number(0))
        );
    }

    @ParameterizedTest
    @DisplayName("유효한 파라미터가 들어올 경우 계산을 할 수 있다.")
    @MethodSource("validRequest")
    void calculateWithValidNumbers(Number number1, OperatorType operator, Number number2, Number expected) {
        Assertions.assertThat(calculators.calculate(number1, operator, number2)).isEqualTo(expected);
    }
}
