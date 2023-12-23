package baseball.generator;

import java.util.List;

public interface NumberGenerator {
    int generate(int startInclusive, int endInclusive);

    List<Integer> generateUniqueNumbers(int startInclusive, int endInclusive, int size);
}
