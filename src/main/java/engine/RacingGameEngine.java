package engine;

import console.InputView;
import console.OutputView;
import domain.Cars;
import domain.Race;
import domain.TryCount;
import utils.CarsFactory;
import utils.RandomPowerGenerator;
import utils.RandomPowerMaker;

public class RacingGameEngine {

    private final RandomPowerGenerator randomPowerGenerator = new RandomPowerMaker();

    public void startGame() {
        final Cars cars = CarsFactory.createCars(getCarNames());
        final TryCount tryCount = new TryCount(getTryCount());
        final Race race = new Race(cars, tryCount);

        startRace(race);

        OutputView.printWinners(cars);
    }

    private String[] getCarNames() {
        OutputView.requestOfCarNames();
        return InputView.inputCarNames();
    }

    private int getTryCount() {
        OutputView.requestOfTryCount();
        return InputView.inputTryCount();
    }

    private void startRace(Race race) {
        OutputView.printResultMessage();
        race.startRace(randomPowerGenerator);
    }
}
