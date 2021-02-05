package racingcar;

public class RacingTimeRegister {

    private static final int MIN_RACING_TIME = 0;

    public int registerRacingTime(String input) {
        try {
            int racingTime = Integer.parseInt(input);

            validateRacingTimeZeroOrLess(racingTime);

            return racingTime;
        } catch (Exception e) {
            //throw new InvalidRacingTimeException();
        }
        return 0;
    }

    private void validateRacingTimeZeroOrLess(int racingTime) {
        if (racingTime <= MIN_RACING_TIME) {
            //throw new InvalidRacingTimeException();
        }
    }
}
