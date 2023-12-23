package baseball.io;

import baseball.domain.BaseballCount;

public class BaseballConsoleOutput implements BaseballOutput {
    @Override
    public void printIntro() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    @Override
    public void printAskForNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    @Override
    public void printBallCount(BaseballCount baseballCount) {
        System.out.println(baseballCount);
    }

    @Override
    public void printOut() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Override
    public void printAskForRetry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
