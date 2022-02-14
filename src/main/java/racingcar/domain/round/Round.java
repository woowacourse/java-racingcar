package racingcar.domain.round;

import racingcar.exception.NotNumericException;
import racingcar.exception.NumberTooSmallException;

public class Round {

    private static final int MIN_NUMBER = 1;

    private int round;

    public Round(String round) {
        this(parseInt(round));
    }

    public Round(int round) {
        validate(round);
        this.round = round;
    }

    private void validate(int round) {
        if (round < MIN_NUMBER) {
            throw new NumberTooSmallException("1 이상의 양수를 입력하세요.");
        }
    }

    private static int parseInt(String round) {
        try {
            return Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw new NotNumericException("1 이상의 양수를 입력하세요.");
        }
    }

    public boolean isEnd(int endRound) {
        if (endRound > round) {
            throw new IllegalArgumentException("현재 시도 회수가 끝나는 시도 회수보다 작을 수 없습니다.");
        }
        return this.isSame(endRound);
    }

    public boolean isSame(int number) {
        return round == number;
    }

    public void decrease() {
        this.round--;
    }
}
