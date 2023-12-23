package baseball.domain;

import java.util.List;

public class NumberSlot {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private static final int SIZE = 3;

    private final List<Integer> numbers;

    public NumberSlot(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
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
