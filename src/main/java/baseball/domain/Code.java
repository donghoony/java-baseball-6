package baseball.domain;

import java.util.Arrays;

public enum Code {
    RETRY("1"),
    EXIT("2")
    ;

    private final String statusCode;

    Code(String statusCode) {
        this.statusCode = statusCode;
    }

    public static Code from(String value) {
        return Arrays.stream(values())
                .filter(code -> code.statusCode.equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
