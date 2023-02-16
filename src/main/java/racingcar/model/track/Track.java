package racingcar.model.track;

import racingcar.exception.InvalidRangeTrialTimesException;
import racingcar.exception.InvalidTrialTimesFormatException;
import racingcar.model.car.Cars;

import java.util.regex.Pattern;

public class Track {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("(\\d)+");
    private static final int TRIAL_MAX_TIMES = 100;
    private static final int TRIAL_MIN_TIMES = 1;
    private static final int ONE_GAME = 1;
    private static final int CAN_GAME = 0;
    private final Cars cars;
    private int trialTimes;

    public Track(final Cars cars, final String trialTimes) {
        validate(trialTimes);

        this.cars = cars;
        this.trialTimes = Integer.parseInt(trialTimes);
    }

    private void validate(final String trialTimes) {
        validateNumber(trialTimes);
        validateRange(trialTimes);
    }

    private void validateNumber(final String trialTimes) {
        if (!NUMBER_PATTERN.matcher(trialTimes).matches()) {
            throw new InvalidTrialTimesFormatException();
        }
    }

    private void validateRange(final String trialTimes) {
        int trialTimesNumber = Integer.parseInt(trialTimes);

        if (trialTimesNumber < TRIAL_MIN_TIMES || trialTimesNumber > TRIAL_MAX_TIMES) {
            throw new InvalidRangeTrialTimesException();
        }
    }

    public Cars race() {
        cars.moveCars();
        removeTrialTimes();
        return cars;
    }

    private void removeTrialTimes() {
        trialTimes -= ONE_GAME;
    }

    public boolean runnable() {
        return trialTimes >= CAN_GAME;
    }

    public Cars findWinner() {
        return cars;
    }
}
