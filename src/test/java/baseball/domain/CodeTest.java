package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CodeTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1, RETRY",
            "2, EXIT"
    })
    @DisplayName("코드를 올바르게 반환한다")
    void validCodeConversion(String code, Code expected) {
        assertThat(Code.from(code)).isEqualTo(expected);
    }

    @Test
    @DisplayName("코드가 올바르지 않다면 예외를 발생한다")
    void invalidCode() {
        Assertions.assertThatThrownBy(() -> Code.from("3"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}