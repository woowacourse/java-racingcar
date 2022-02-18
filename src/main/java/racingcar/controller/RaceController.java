package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.view.OutputView;

public class RaceController {
    private static final int DEFAULT_POSITION = 0;

    public void race(final RacingGame racingGame) {
        OutputView.printResultPrefix();
        while (!racingGame.isEnd()) {
            racingGame.raceRound();
            OutputView.printPosition(racingGame.getCars());
        }
        OutputView.printWinner(racingGame.getCars());
    }

    public Cars insertCarFromCarNames(final String[] carNames) {
        Cars cars = new Cars();
        for (String carName : carNames) {
            cars.insertCar(new Car(carName, DEFAULT_POSITION));
        }
        return cars;
    }
}
