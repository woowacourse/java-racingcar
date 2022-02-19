package racingcar.domain.round;

import static racingcar.utils.IntegerUtils.parseInt;

public class Round {

    private static final int MIN_NUMBER = 1;
    private static final int END_OF_ROUND = 0;
    private static final String NOT_MIN_NUMBER_ERROR_MESSAGE = MIN_NUMBER + " 이상의 양수를 입력하세요.";

    private int round;

    public Round(String round) {
        this(parseInt(round, new IllegalArgumentException(NOT_MIN_NUMBER_ERROR_MESSAGE)));
    }

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

    public int getRound() {
        return round;
    }
}
