package racingcar.domain;

public class Round {
    private static final int MINIMUM_ROUND = 0;

    private int remainingRound;

    public Round(int round) {
        validateRound(round);
        this.remainingRound = round;
    }

    private void validateRound(int round) {
        if (round < MINIMUM_ROUND) {
            throw new IllegalArgumentException(
                    String.format("시도할 횟수는 %d보다 작을 수 없습니다.", MINIMUM_ROUND));
        }
    }

    public boolean isPlayable() {
        return remainingRound > MINIMUM_ROUND;
    }

    public void decrease() {
        this.remainingRound--;
    }
}
