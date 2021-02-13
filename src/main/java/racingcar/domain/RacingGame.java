package racingcar.domain;

import racingcar.utils.FixedNumberGeneratingStrategy;
import racingcar.utils.NumberGeneratingStrategy;
import racingcar.utils.RandomNumberGeneratingStrategy;
import racingcar.view.GameResultView;

public class RacingGame {

    private final Cars cars;
    private final int turns;
    private final NumberGeneratingStrategy numberGeneratingStrategy;

    public RacingGame(Cars cars, int turns,
            NumberGeneratingStrategy numberGeneratingStrategy) {
        this.cars = cars;
        this.turns = turns;
        this.numberGeneratingStrategy = numberGeneratingStrategy;
    }

    public RacingGame(String carNames, int turns,
            NumberGeneratingStrategy numberGeneratingStrategy) {
        this(Cars.from(carNames), turns, numberGeneratingStrategy);
    }

    public static RacingGame getFixedNumberRacingGame(String carNames, int turns) {
        return new RacingGame(carNames, turns, new FixedNumberGeneratingStrategy());
    }

    public static RacingGame getRandomNumberRacingGame(String carNames, int turns) {
        return new RacingGame(carNames, turns, new RandomNumberGeneratingStrategy());
    }

    public RacingGameResult startGame() {
        GameResultView.printResultPrefix();
        GameResultView.printCarsBeforeRace(cars);

        race();

        return new RacingGameResult(cars);
    }

    private void race() {
        for (int i = 0; i < turns; i++) {
            cars.driveAll(numberGeneratingStrategy);
            GameResultView.printCars(cars.getCars());
        }
    }
}
