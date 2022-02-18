package racingcar.domain;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class RacingGame {

    private static final int MINIMUM_TRIAL_NUMBER = 1;
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String EXCEPTION_TRIAL_NUMBER = "[ERROR] 시도횟수는 1이상의 자연수여야 합니다.\n";
    private RacingCars racingCars;
    private int trialCount;

    public RacingGame(String carNames, int trialCount) {
        this.trialCount = trialCount;
        checkTrialCountIsNaturalNumber();
        racingCars = new RacingCars(Arrays.asList(carNames.split(CAR_NAME_DELIMITER)));
    }

    private void checkTrialCountIsNaturalNumber() {
        if (trialCount < MINIMUM_TRIAL_NUMBER) {
            throw new IllegalArgumentException(EXCEPTION_TRIAL_NUMBER);
        }
    }

    public void playGame() {
        OutputView.printGameStartMessage();
        for (int i = 0; i < trialCount; i++) {
            doOneTrial();
            OutputView.printCurrentRaceState(racingCars.getCurrentRaceState());
        }
        OutputView.printWinners(racingCars.getWinnerNames());
    }

    private void doOneTrial() {
        racingCars.moveCars();
    }
}
