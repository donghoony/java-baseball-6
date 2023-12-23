package baseball;

import baseball.domain.Computer;
import baseball.generator.NumberGenerator;
import baseball.generator.RandomNumberGenerator;
import baseball.io.BaseballConsoleInput;
import baseball.io.BaseballConsoleOutput;
import baseball.io.BaseballInput;
import baseball.io.BaseballOutput;

public class Application {
    public static void main(String[] args) {
        BaseballInput input = new BaseballConsoleInput();
        BaseballOutput output = new BaseballConsoleOutput();
        NumberGenerator generator = new RandomNumberGenerator();
        Computer computer = new Computer(generator);

        BaseballClient baseballClient = new BaseballClient(input, output, computer);
        do {
            baseballClient.play();
        } while (baseballClient.askForRetry());
    }
}
