package racingcar.domain;

public class Round {

    private final int round;

    public Round(final int round) {
        checkPositiveRound(round);
        this.round = round;
    }

    private void checkPositiveRound(final int round) {
        if (round <= 0) {
            throw new IllegalArgumentException("라운드는 0이하의 값이 들어올 수 없다.");
        }
    }
}
