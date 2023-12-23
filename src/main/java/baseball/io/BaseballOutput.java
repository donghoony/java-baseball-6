package baseball.io;

import baseball.domain.BaseballCount;

public interface BaseballOutput {

    void printIntro();

    void printAskForNumbers();

    void printBallCount(BaseballCount baseballCount);

    void printOut();

    void printAskForRetry();

}
