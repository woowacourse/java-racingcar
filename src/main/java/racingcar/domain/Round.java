package racingcar.domain;

public class Round {
    private static final int MIN_ROUND = 1;
    private final int round;

    public Round(final int round) {
        if (round < MIN_ROUND) {
            throw new IllegalStateException("1 이상의 숫자를 입력해주세요.");
        }
        this.round = round;
    }

    public int get() {
        return round;
    }
}
