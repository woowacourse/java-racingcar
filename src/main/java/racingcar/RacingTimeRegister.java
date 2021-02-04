package racingcar;

import racingcar.exception.InvalidRacingTimeException;

public class RacingTimeRegister {

    private static final int MIN_RACING_TIME = 0;

    public int registerRacingTime(String input) {
        int racingTime;

        try {
            racingTime = Integer.parseInt(input);
        } catch (Exception e) {
            throw new InvalidRacingTimeException();
        }
        validateRacingTimeZeroOrLess(racingTime);

        return racingTime;
    }

    private void validateRacingTimeZeroOrLess(int racingTime) {
        if (racingTime <= 0) {
            throw new InvalidRacingTimeException();
        }
    }
}
