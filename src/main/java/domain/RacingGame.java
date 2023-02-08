package domain;

public class RacingGame {

    private static final int ROUND_MIN_SIZE = 1;
    private static final int MOVABLE_MIN_NUMBER = 4;
    private static final String ROUND_SIZE_ERROR = "[ERROR] 시도 횟수는 1이상이어야 합니다.";

    private int round;
    private NumberGenerator numberGenerator;

    public RacingGame(int round, NumberGenerator numberGenerator) {
        validateRound(round);
        this.round = round;
        this.numberGenerator = numberGenerator;
    }

    private void validateRound(int round) {
        if (round < ROUND_MIN_SIZE) {
            throw new IllegalArgumentException(ROUND_SIZE_ERROR);
        }
    }

    private boolean isMovable() {
        int number = numberGenerator.generate();
        return number >= MOVABLE_MIN_NUMBER;
    }
}
