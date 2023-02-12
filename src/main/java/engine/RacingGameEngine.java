package engine;

import console.InputView;
import console.OutputView;
import domain.Cars;
import domain.Game;
import utils.CarsFactory;
import utils.RandomPowerGenerator;
import utils.RandomPowerMaker;

public class RacingGameEngine {

    private final RandomPowerGenerator randomPowerGenerator = new RandomPowerMaker();

    public void startGame() {
        final Cars cars = CarsFactory.createCars(getCarNames());
        final Game game = new Game(getTryCount());

        startRace(cars, game);

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

    private void startRace(final Cars cars, final Game game) {
        OutputView.printResultMessage();

        for (int i = 0; i < game.getTryCount(); i++) {
            cars.moveAll(randomPowerGenerator);
            OutputView.printCurrentRacingStatus(cars);
        }
    }
}
