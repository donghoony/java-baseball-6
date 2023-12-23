
package baseball.domain;
public record BaseballCount (int strikeCount, int ballCount) {

    public boolean isOut() {
        return strikeCount == NumberSlot.SIZE;
    }

    public boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }
}
