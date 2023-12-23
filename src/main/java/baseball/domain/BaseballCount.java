package baseball.domain;

public record BaseballCount(int strikeCount, int ballCount) {

    public boolean isOut() {
        return strikeCount == NumberSlot.SIZE;
    }

    public boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (isNothing()) {
            return "낫싱";
        }
        if (ballCount > 0) {
            stringBuilder.append(ballCount).append("볼 ");
        }
        if (strikeCount > 0) {
            stringBuilder.append(strikeCount).append("스트라이크");
        }
        return stringBuilder.toString();
    }
}
