package engine;

import console.InputView;
import console.OutputView;
import domain.Cars;
import utils.CarsFactory;
import utils.RandomPowerGenerator;
import utils.RandomPowerMaker;

public class RacingGameEngine {

    private final RandomPowerGenerator randomPowerGenerator = new RandomPowerMaker();

    public void startGame() {
        final Cars cars = CarsFactory.createCars(getCarNames());
        final int tryCount = getTryCount();

        startRace(cars, tryCount);

        OutputView.printWinners(cars);
    }

    private String getCarNames() {
        OutputView.requestOfCarNames();
        return InputView.inputCarNames();
    }

    private int getTryCount() {
        OutputView.requestOfTryCount();
        return InputView.inputTryCount();
    }

    private void startRace(final Cars cars, final int tryCount) {
        OutputView.printResultMessage();

        for (int i = 0; i < tryCount; i++) {
            cars.moveAll(randomPowerGenerator);
            OutputView.printCurrentRacingStatus(cars);
        }
    }
}
