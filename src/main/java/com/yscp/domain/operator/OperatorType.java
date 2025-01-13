package com.yscp.domain.operator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum OperatorType {

    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    MOD("/"),
    ;

    private final String type;
    private static final Map<String, OperatorType> MAPPINGS = new HashMap<>();

    static {
        Arrays.stream(OperatorType.values())
                .forEach(operatorType -> MAPPINGS.put(operatorType.type, operatorType));
    }

    OperatorType(String type) {
        this.type = type;
    }

    public static OperatorType from(String requestType) {
        if (requestType == null || requestType.isBlank()) {
            throw new IllegalArgumentException("Request must not be null ");
        }

        return Optional.ofNullable(MAPPINGS.get(requestType))
                .orElseThrow(() -> new IllegalArgumentException("Unknown operator type: " + requestType));
    }
}
