package racingcar.domian;

import racingcar.domian.car.Car;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    private static final int ZERO = 0;

    private Cars cars;
    private GameRound gameRound;

    public RacingGame(String carNames, String gameRound) {
        setUpCars(carNames);
        setUpRound(gameRound);
        startGame();
    }

    private void setUpCars(String carNames) {
        this.cars = new Cars(carNames);
    }

    private void setUpRound(String gameRound) {
        this.gameRound = new GameRound(gameRound);
    }

    private void startGame() {
        for (int i = ZERO; i < gameRound.getGameRound(); i++) {
            cars.moveAll();
            OutputView.printCurrentRound(cars.getCars());
        }
    }

    public List<Car> getResult() {
        return Winners.findWinner(cars.getCars());
    }
}
