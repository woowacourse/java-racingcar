package racingcar.domain.round;

import racingcar.exception.NotIntegerException;
import racingcar.exception.NumberTooSmallException;
import racingcar.utils.IntegerUtils;

public class Round {

    private static final String ERROR_MESSAGE = "1 이상의 양수를 입력하세요.";
    private static final int END_ROUND = 0;
    private static final int MIN_NUMBER = 1;

    private int round;

    public Round(String round) {
        this(IntegerUtils.parseInt(round, new NotIntegerException(ERROR_MESSAGE)));
    }

    public Round(int round) {
        validate(round);
        this.round = round;
    }

    private void validate(int round) {
        if (round < MIN_NUMBER) {
            throw new NumberTooSmallException(ERROR_MESSAGE);
        }
    }


    public boolean isEnd() {
        return round <= END_ROUND;
    }

    public void decrease() {
        this.round--;
    }
}
