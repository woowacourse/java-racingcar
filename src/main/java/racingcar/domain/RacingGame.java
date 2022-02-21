package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class RacingGame {

    private static final int MINIMUM_NATURAL_NUMBER = 1;
    private static final int END_CONDITION = 0;
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String EXCEPTION_TRIAL_NUMBER = "[ERROR] 시도횟수는 1이상의 자연수여야 합니다.\n";
    private final RacingCars racingCars;
    private int trialCount;

    public RacingGame(String carNames, int trialCount) {
        isNaturalNumber(trialCount);
        this.trialCount = trialCount;
        this.racingCars = new RacingCars(Arrays.asList(carNames.split(CAR_NAME_DELIMITER)));
    }

    private void isNaturalNumber(int number) {
        if (number < MINIMUM_NATURAL_NUMBER) {
            throw new IllegalArgumentException(EXCEPTION_TRIAL_NUMBER);
        }
    }

    public boolean isEnd() {
        return trialCount == END_CONDITION;
    }

    public List<String> getWinners() {
        return racingCars.getWinnerNames();
    }

    public void doOneTrial() {
        racingCars.moveCars();
        --trialCount;
    }

    public RacingCars getRacingCars() {
        return this.racingCars;
    }
}
