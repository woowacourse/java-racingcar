package racingcar.domain.round;

import static racingcar.utils.IntegerUtils.parseInt;

import java.util.Objects;

public class Round {

    private static final int MIN_NUMBER = 1;
    private static final int END_OF_ROUND = 0;
    public static final String NOT_MIN_NUMBER_ERROR_MESSAGE = MIN_NUMBER + " 이상의 양수를 입력하세요.";

    private int round;

    public Round(int round) {
        validate(round);
        this.round = round;
    }

    private void validate(int round) {
        if (round < MIN_NUMBER) {
            throw new IllegalArgumentException(NOT_MIN_NUMBER_ERROR_MESSAGE);
        }
    }

    public boolean isEnd() {
        return round == END_OF_ROUND;
    }

    public void decrease() {
        this.round--;
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
