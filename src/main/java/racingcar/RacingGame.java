package racingcar;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final String EXCEPTION_TRIAL_NUMBER = "[ERROR] 시도횟수는 1이상의 자연수여야 합니다.\n";
    private RacingCars racingCars;
    private int trialCount;

    public RacingGame() {
    }

    private void makeRacingCars() {
        List<String> carNameBucket = InputView.askCarName();
        trialCount = InputView.askTryCount();
        checkTrialCountIsNaturalNumber();
        racingCars = new RacingCars(carNameBucket);
    }

    private void checkTrialCountIsNaturalNumber() {
        if (trialCount < 1) {
            throw new IllegalArgumentException(EXCEPTION_TRIAL_NUMBER);
        }
    }

    public void playGame() {
        makeRacingCars();
        OutputView.printGameStartMessage();
        for (int i = 0; i < trialCount; i++) {
            doOneTrial();
            OutputView.printCurrentRaceState(racingCars.getCurrentRaceState());
        }
        OutputView.printWinners(racingCars.getWinnerNameBucket());
    }

    private void doOneTrial() {
        racingCars.moveCars();
    }
}
