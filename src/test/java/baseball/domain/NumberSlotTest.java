package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumberSlotTest {

    @Test
    @DisplayName("올바른 수가 들어가면 예외가 발생하지 않는다")
    void validNumberTest() {
        // given
        List<Integer> numbers = List.of(1, 2, 3);
        // when, then
        assertDoesNotThrow(() -> new NumberSlot(numbers));
    }

    static Stream<Arguments> genList() {
        return Stream.of(Arguments.of(List.of(1, 2)), Arguments.of(List.of(1, 2, 3, 4)), Arguments.of(List.of(1)));
    }

    @ParameterizedTest
    @MethodSource("genList")
    @DisplayName("길이가 올바르지 않은 경우 예외를 발생한다")
    void invalidLengthTest(List<Integer> numbers) {
        // when, then
        assertThatThrownBy(() -> new NumberSlot(numbers)).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("같은 수가 중복되면 예외를 발생한다")
    void duplicateNumberTest() {
        // given
        List<Integer> numbers = List.of(1, 2, 2);
        // when, then
        assertThatThrownBy(() -> new NumberSlot(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("범위를 넘어가는 경우 예외를 발생한다.")
    void outOfRangeTest() {
        // given
        List<Integer> numbers = List.of(0, 1, 2);
        // when, then
        assertThatThrownBy(() -> new NumberSlot(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("스트라이크, 볼을 정확하게 계산한다")
    void calculate() {
        // given
        List<Integer> numbers1 = List.of(1, 2, 3);
        List<Integer> numbers2 = List.of(1, 3, 4);
        NumberSlot slot1 = new NumberSlot(numbers1);
        NumberSlot slot2 = new NumberSlot(numbers2);
        // when
        BaseballCount count = slot1.calculate(slot2);
        // then
        Assertions.assertThat(count).isEqualTo(new BaseballCount(1, 1));
    }
}
