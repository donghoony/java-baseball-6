package baseball;

import baseball.domain.BaseballCount;
import baseball.domain.Code;
import baseball.domain.Computer;
import baseball.domain.NumberSlot;
import baseball.io.BaseballInput;
import baseball.io.BaseballOutput;
import java.util.List;

public class BaseballClient {
    private final BaseballInput input;
    private final BaseballOutput output;
    private final Computer computer;

    public BaseballClient(BaseballInput input, BaseballOutput output, Computer computer) {
        this.input = input;
        this.output = output;
        this.computer = computer;

        output.printIntro();
    }

    public void play() {
        computer.refreshAnswer();
        BaseballCount baseballCount;

        do {
            output.printAskForNumbers();
            List<Integer> numbers = input.getNumbers();
            NumberSlot playerNumbers = new NumberSlot(numbers);
            baseballCount = computer.calculateBallCount(playerNumbers);
            output.printBallCount(baseballCount);
        } while (!baseballCount.isOut());

        output.printOut();
    }

    public boolean askForRetry() {
        output.printAskForRetry();
        String retry = input.getRetry();
        Code retryCode = Code.from(retry);
        return retryCode == Code.RETRY;
    }

}
