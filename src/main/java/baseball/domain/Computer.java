package baseball.domain;

import baseball.generator.NumberGenerator;
import java.util.List;

public class Computer {
    private final NumberGenerator numberGenerator;
    private NumberSlot numberSlot;

    public Computer(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void refreshAnswer() {
        List<Integer> answer = numberGenerator.generateUniqueNumbers(
                NumberSlot.MIN_RANGE, NumberSlot.MAX_RANGE, NumberSlot.SIZE);
        this.numberSlot = new NumberSlot(answer);
    }

    public BaseballCount calculateBallCount(NumberSlot playerNumbers) {
        return numberSlot.calculate(playerNumbers);
    }
}
