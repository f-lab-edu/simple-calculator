package com.yscp.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorGameTest {
//"1 + 3 + 4, 8",


    /**
     * 1 - 2 + 3 * 4 / 2
     * [1,2,3,4,2]
     * [-,+,*,/]
     */
    @ParameterizedTest
    @DisplayName("문자열에서 숫자와 산술연산자를 구분하여 실행할 수 있다.")
    @CsvSource(value = { "1 - 2 + 3 * 4 / 2, 5"})
    void start(String input, Integer result) {
        CalculatorGame calculatorGame = new CalculatorGame();
        Number resultNumber = new Number(result);
        Assertions.assertThat(calculatorGame.calculate(input)).isEqualTo(resultNumber);
    }
}
