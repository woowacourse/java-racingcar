package racingcar;

import racingcar.exception.InvalidRacingTimeException;

public class RacingTimeRegister {

    public int registerRacingTime(String input) {
        int racingTime = 0;

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
