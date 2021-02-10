package racingCar.domain;

import racingCar.exception.InvalidNumOfMoveException;

public class Round {

    public static final String ERROR_MESSAGE_ROUND_COUNT_NATURAL_NUMBER = "시도횟수는 자연수이어야 합니다.";
    private final int round;

    public Round(int round) {
        if (round < 0 ){
            throw new InvalidNumOfMoveException(ERROR_MESSAGE_ROUND_COUNT_NATURAL_NUMBER);
        }
        this.round = round;
    }

    public Round goOn() {
        return new Round(round -1);
    }

    public boolean isEnd() {
        return round == 0;
    }
}
