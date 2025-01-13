package com.yscp.domain;

import com.yscp.domain.operator.MinusOperator;
import com.yscp.domain.operator.Operator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("MinusOperator")
class MinusOperatorTest {

    Operator operator;

    @BeforeEach
    void setUp() {
        operator = new MinusOperator();
    }

    @ParameterizedTest
    @DisplayName("Number1 에서 Number2를 뺄 수 있다.")
    @CsvSource(value = {"1,-1,2", "1,1,0", "-1,-1,0"})
    void minusNumber2FromNumber1(Integer number1, Integer number2, Integer result) {
        Number resultNumber = new Number(result);
        Assertions.assertThat(operator.operate(new Number(number1), new Number(number2))).isEqualTo(resultNumber);
    }
}
