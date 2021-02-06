package racingcar.domain;

import racingcar.exception.InvalidRacingTimeException;
import racingcar.exception.InvalidRacingTimeTypeException;

public class RacingTimeRegister {

    private static final int MIN_RACING_TIME = 0;

    public int registerRacingTime(String input) {
        try {
            int racingTime = Integer.parseInt(input);

            validateRacingTimeZeroOrLess(racingTime);

            return racingTime;
        } catch (IllegalArgumentException e) {
            throw new InvalidRacingTimeTypeException(
                    "[ERROR] 레이스 횟수는 int 형 타입이어야 합니다.");
        }
    }

    private void validateRacingTimeZeroOrLess(int racingTime) {
        if (racingTime <= MIN_RACING_TIME) {
            throw new InvalidRacingTimeException(
                    "[ERROR] 레이스 횟수는 자연수만 입력 가능합니다.");
        }
    }
}
