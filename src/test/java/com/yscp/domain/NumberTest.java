package com.yscp.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Number")
class NumberTest {

    @ParameterizedTest
    @DisplayName("생성자는 유효한 숫자 문자를 받았을 경우 숫자 고유 객체를 생성한다.")
    @CsvSource(value = {"1,1", "-1,-1", "0,0"})
    void constructorWithValidParameter(String numberString, Integer result) {
        Number number = new Number(numberString);
        Assertions.assertThat(number.value()).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 문자인 경우 예외를 던진다.")
    @CsvSource(value = {"a", "&", "*"})
    void itThrowExceptionWhenNotNumberString(String numberString) {
        Assertions.assertThatThrownBy(() -> new Number(numberString));
    }

    @ParameterizedTest
    @DisplayName("빈 문자열 공백인 경우 예외를 던진다.")
    @NullAndEmptySource
    void itThrowExceptionWhenNullOrEmptyString(String numberString) {
        Assertions.assertThatThrownBy(() -> new Number(numberString));
    }


    @ParameterizedTest
    @DisplayName("숫자를 나눌 수 있다.")
    @CsvSource(value = {"9,3,3", "4,2,2", "4,5,0"})
    void mod(Integer number1, Integer number2, Integer result) {
        Number number = new Number(number1);
        Number otherNumber = new Number(number2);

        Number resultNumber = new Number(result);
        Assertions.assertThat(number.mod(otherNumber)).isEqualTo(resultNumber);
    }

    @ParameterizedTest
    @DisplayName("숫자를 더할 수 있다.")
    @CsvSource(value = {"9,3,12", "4,2,6", "4,5,9"})
    void plus(Integer number1, Integer number2, Integer result) {
        Number number = new Number(number1);
        Number otherNumber = new Number(number2);

        Number resultNumber = new Number(result);
        Assertions.assertThat(number.plus(otherNumber)).isEqualTo(resultNumber);
    }

    @ParameterizedTest
    @DisplayName("숫자를 뺄 수 있다.")
    @CsvSource(value = {"9,3,6", "4,2,2", "4,5,-1"})
    void minus(Integer number1, Integer number2, Integer result) {
        Number number = new Number(number1);
        Number otherNumber = new Number(number2);

        Number resultNumber = new Number(result);
        Assertions.assertThat(number.minus(otherNumber)).isEqualTo(resultNumber);
    }

    @ParameterizedTest
    @DisplayName("숫자를 곱할 수 있다.")
    @CsvSource(value = {"9,3,27", "4,2,8", "4,5,20"})
    void multiply(Integer number1, Integer number2, Integer result) {
        Number number = new Number(number1);
        Number otherNumber = new Number(number2);

        Number resultNumber = new Number(result);
        Assertions.assertThat(number.multiply(otherNumber)).isEqualTo(resultNumber);
    }

}
