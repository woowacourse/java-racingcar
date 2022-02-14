package racingcar.domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Round round1 = (Round) o;
        return round == round1.round;
    }

    @Override
    public int hashCode() {
        return Objects.hash(round);
    }
}
