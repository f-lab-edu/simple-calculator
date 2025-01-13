package com.yscp.domain.strategy;

import com.yscp.domain.Number;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BasicStrategyTest {


    @ParameterizedTest
    @DisplayName("곱셈 나눗셈 우선순위를 둔 일방적인 계산기능을 수행할 수 있다.")
    @CsvSource(value = {"1 - 2 + 3 * 4 / 2, 5"})
    void calculate(String input, Integer result) {

        CalculatorStrategy basicStrategy = new BasicStrategy();
        Number resultNumber = new Number(result);
        Assertions.assertThat(basicStrategy.calculate(input)).isEqualTo(resultNumber);
    }
}
