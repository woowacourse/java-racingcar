package racingcar.domain;

/**
 * Round.java
 * 게임의 회차를 담당하는 클래스
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */
public class Round {
    private static final String ERROR_INVALID_RANGE = "회수는 양의 정수만 가능합니다.";

    private final int finalRound;
    private int currentRound;

    private Round(int finalRound) {
        this.finalRound = finalRound;
        this.currentRound = 0;
    }

    public static Round from(int finalRound) {
        isValidValueOrThrow(finalRound);
        return new Round(finalRound);
    }

    public static boolean isValidValueOrThrow(int finalRound) {
        if (finalRound <= 0) {
            throw new IllegalArgumentException(ERROR_INVALID_RANGE);
        }
        return true;
    }

    public void nextRound() {
        this.currentRound++;
    }

    public boolean isEnd() {
        return this.finalRound <= this.currentRound;
    }
}
