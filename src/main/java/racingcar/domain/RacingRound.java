package racingcar.domain;

public class RacingRound {
    private final int round;

    public RacingRound(int round) {
        validateRound(round);
        this.round = round;
    }

    private void validateRound(int round) {
        if (round < 1) {
            throw new IllegalArgumentException("경기 라운드는 1이상만 가능합니다.");
        }
    }

    public int getRound() {
        return this.round;
    }
}
