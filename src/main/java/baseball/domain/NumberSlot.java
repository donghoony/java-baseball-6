package baseball.domain;

import java.util.List;
import java.util.stream.IntStream;

public class NumberSlot {
    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 9;
    public static final int SIZE = 3;

    private final List<Integer> numbers;

    public NumberSlot(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public BaseballCount calculate(NumberSlot slot) {
        int strikeCount = countStrikes(slot);
        int ballCount = countBalls(slot);
        return new BaseballCount(strikeCount, ballCount);
    }

    private int countStrikes(NumberSlot slot) {
        return (int) IntStream.range(0, SIZE)
                .filter(index -> this.numbers.get(index).equals(slot.numbers.get(index)))
                .count();
    }

    private int countBalls(NumberSlot slot) {
        int ballCount = 0;
        for (int i = 0; i < SIZE; i++) {
            int number = numbers.get(i);
            if (number != slot.numbers.get(i) && slot.numbers.contains(number)) {
                ballCount++;
            }
        }
        return ballCount;
    }


    private void validateNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateUniqueNumbers(numbers);
        validateNumbersInRange(numbers);
    }


    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUniqueNumbers(List<Integer> numbers) {
        int count = (int) numbers.stream()
                .distinct()
                .count();
        if (count != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        int validNumberCount = (int) numbers.stream()
                .filter(this::isNumberInRange)
                .count();

        if (validNumberCount != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumberInRange(int number) {
        return MIN_RANGE <= number && number <= MAX_RANGE;
    }
}
