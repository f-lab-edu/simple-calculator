package com.yscp.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


@DisplayName("PlusOperator ")
class PlusOperatorTest {

    private Operator operator;

    @BeforeEach
    void setUp() {
        operator = new PlusOperator();
    }

    @ParameterizedTest
    @DisplayName("숫자 2개를 더할 수 있다.")
    @CsvSource(value = {"0,1,1", "1,-1,0"})
    void itReturnsSumNumber1AndNumber2(int number1, int number2, int result) {
        Assertions.assertThat(operator.operate(number1, number2)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("nullParameters")
    @DisplayName("숫자 중 null 값이 들어올 경우 예외를 던진다.")
    void itThrowsNullPointerExceptionWhenNumberIsNull(Integer number1, Integer number2) {
        Assertions.assertThatThrownBy(() -> operator.operate(number1, number2));
    }

    public static Stream<Arguments> nullParameters() {
        return Stream.of(Arguments.of(null, 1),
                Arguments.of(1, null),
                Arguments.of(null, null));
    }

}
