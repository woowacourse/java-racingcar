package domain;

public class RacingGame {

    private static final int ROUND_MIN_SIZE = 1;
    private static final String ROUND_SIZE_ERROR = "[ERROR] 시도 횟수는 1이상이어야 합니다.";

    private int round;

    public RacingGame(int round) {
        validateRound(round);
        this.round = round;
    }

    private void validateRound(int round) {
        if (round < ROUND_MIN_SIZE) {
            throw new IllegalArgumentException(ROUND_SIZE_ERROR);
        }
    }

}
