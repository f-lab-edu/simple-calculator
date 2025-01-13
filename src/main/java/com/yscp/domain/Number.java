package com.yscp.domain;

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
}
