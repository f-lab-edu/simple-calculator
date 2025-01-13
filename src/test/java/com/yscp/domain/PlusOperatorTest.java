package com.yscp.domain;

import com.yscp.domain.operator.Operator;
import com.yscp.domain.operator.PlusOperator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
        Number resultNumber = new Number(result);
        Assertions.assertThat(operator.operate(new Number(number1), new Number(number2))).isEqualTo(resultNumber);
    }

}
