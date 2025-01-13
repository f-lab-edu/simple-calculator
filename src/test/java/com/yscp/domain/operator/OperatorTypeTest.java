package com.yscp.domain.operator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("OperatorType")
class OperatorTypeTest {

    @ParameterizedTest
    @DisplayName("문자열에 해당하는 산술 타입을 조회할 수 있다.")
    @MethodSource("operatorRequestAndResult")
    void itReturnsOperatorType(String requestType, OperatorType operatorType) {
        Assertions.assertThat(OperatorType.from(requestType)).isEqualTo(operatorType);
    }


    public static Stream<Arguments> operatorRequestAndResult() {
        return Stream.of(Arguments.of("+", OperatorType.PLUS),
                Arguments.of("-", OperatorType.MINUS),
                Arguments.of("*", OperatorType.MULTIPLY),
                Arguments.of("/", OperatorType.MOD)
        );
    }

    @DisplayName("요청이 null 값 또는 빈값일 경우 예외를 던진다.")
    @ParameterizedTest
    @NullAndEmptySource
    void itThrowExceptionWhenNullOrEmptyRequest(String request) {
        Assertions.assertThatThrownBy(() -> OperatorType.from(request))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("존재하지 않는 String 값일 경우 예외를 던진다.")
    @ParameterizedTest
    @CsvSource(value = {"++", "--", "aa"})
    void itThrowExceptionWhenInvalidString(String request) {
        Assertions.assertThatThrownBy(() -> OperatorType.from(request))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
