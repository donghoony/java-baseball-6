package baseball.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballConsoleInput implements BaseballInput {
    @Override
    public List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();

        String input = Console.readLine();
        validateDigit(input);

        for (Character c : input.toCharArray()) {
            numbers.add(c - '0');
        }

        return numbers;
    }

    @Override
    public String getRetry() {
        return Console.readLine();
    }

    private void validateDigit(String input) {
        for (Character c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

}
