package engine;

import console.InputView;
import console.OutputView;
import domain.Cars;
import domain.TryCount;
import utils.CarsFactory;
import utils.RandomPowerGenerator;
import utils.RandomPowerMaker;

public class RacingGameEngine {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RandomPowerGenerator randomPowerGenerator = new RandomPowerMaker();

    public void startGame() {
        final Cars cars = CarsFactory.createCars(getCarNames());
        final TryCount tryCount = new TryCount(getTryCount());

        startRace(cars, tryCount);

        outputView.printWinners(cars);
    }

    private String[] getCarNames() {
        outputView.requestOfCarNames();
        return inputView.inputCarNames();
    }

    private int getTryCount() {
        outputView.requestOfTryCount();
        return inputView.inputTryCount();
    }

    private void startRace(Cars cars, TryCount tryCount) {
        outputView.printResultMessage();
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            cars.moveAll(randomPowerGenerator);
            outputView.printCurrentRacingStatus(cars);
        }
    }
}
