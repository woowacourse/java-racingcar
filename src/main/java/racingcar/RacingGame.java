package racingcar;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private RacingCars racingCars;
    private int trialCount;

    public RacingGame() {
    }

    private void makeRacingCars() {
        List<String> carNameBucket = InputView.askCarName();
        trialCount = InputView.askTryCount();
        racingCars = new RacingCars(carNameBucket);
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
