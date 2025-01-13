package com.yscp.domain;

import java.util.Objects;

public class Number {
    private final Integer value;

    public Number(String numberString) {
        this(Integer.parseInt(numberString));
    }

    public Number(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return value;
    }

    public Number minus(Number other) {
        return new Number(value - other.value);
    }

    public Number mod(Number other) {
        return new Number(value / other.value);
    }

    public Number plus(Number other) {
        return new Number(value + other.value);
    }

    public Number multiply(Number other) {
        return new Number(value * other.value);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Number number)) return false;
        return Objects.equals(value, number.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
