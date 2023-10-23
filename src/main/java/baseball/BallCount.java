package baseball;

import static baseball.GameClient.BALL_LENGTH;

/**
 * 스트라이크, 볼 개수를 저장하는 클래스.
 */
public class BallCount {
    private final String MESSAGE_BALL = "볼";
    private final String MESSAGE_STRIKE = "스트라이크";
    private final String MESSAGE_NOTHING = "낫싱";

    private final int strike;
    private final int ball;

    public BallCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isOut() {
        return this.strike == BALL_LENGTH;
    }

    private boolean isNothing() {
        return this.strike == 0 && this.ball == 0;
    }

    @Override
    public String toString() {
        if (this.isNothing()) {
            return MESSAGE_NOTHING;
        }
        if (this.ball > 0 && this.strike > 0) {
            return String.format("%d%s %d%s", this.ball, MESSAGE_BALL, this.strike, MESSAGE_STRIKE);
        }
        if (this.ball > 0) {
            return String.format("%d%s", this.ball, MESSAGE_BALL);
        }
        if (this.strike > 0) {
            return String.format("%d%s", this.strike, MESSAGE_STRIKE);
        }
        return "";
    }
}
