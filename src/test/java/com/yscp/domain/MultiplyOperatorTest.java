package com.yscp.domain;

import com.yscp.domain.operator.MultiplyOperator;
import com.yscp.domain.operator.Operator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("MultiplyOperator")
class MultiplyOperatorTest {

    private Operator operator;

    @BeforeEach
    void setUp() {
        operator = new MultiplyOperator();
    }

    @ParameterizedTest
    @DisplayName("두 숫자를 곱할 수 있다.")
    @CsvSource(value = {"4,-4,-16", "2,2,4", "-4,-4,16"})
    void itReturnsMultiplyNumber(Integer number1, Integer number2, Integer result) {
        Number resultNumber = new Number(result);
        Assertions.assertThat(operator.operate(new Number(number1), new Number(number2))).isEqualTo(resultNumber);
    }
}
