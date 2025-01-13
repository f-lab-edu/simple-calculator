package com.yscp.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
}
