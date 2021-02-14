package racingCar.domain;

import java.util.Objects;
import racingCar.exception.InvalidNumOfMoveException;

public class Round {

    public static final String ERROR_MESSAGE_ROUND_COUNT_NATURAL_NUMBER = "시도횟수는 자연수이어야 합니다.";

    private final int round;

    public Round(int round) {
        if (round < 0) {
            throw new InvalidNumOfMoveException(ERROR_MESSAGE_ROUND_COUNT_NATURAL_NUMBER);
        }
        this.round = round;
    }

    public Round next() {
        return new Round(round - 1);
    }

    public boolean isFinish() {
        return round == 0;
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
