package racingcar.controller;

import racingcar.RandomGenerator;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private final RacingCars racingCars;

    public RacingGame() {
        this.racingCars = new RacingCars();
    }

    public RacingGame(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void playGame() {
        racingCars.join(InputView.askCarName());
        String tryCount = InputView.askTryCount();
        Validator.checkTryCountIsNaturalNumber(tryCount);
        int trialCount = Validator.convertToInt(tryCount);

        OutputView.printGameStartMessage();
        for (int i = 0; i < trialCount; i++) {
            moveCar(racingCars);
            OutputView.printCurrentRacingSituation(racingCars);
        }
    }

    private void moveCar(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            racingCar.goOrStay(RandomGenerator.generateRandomNumber());
        }
    }

    public void finish() {
        OutputView.printWinners(racingCars);
    }

}
