package racingcar.domian;

import racingcar.view.OutputView;

public class RacingGame {
    private static final int ZERO = 0;

    private Cars cars;
    private GameRound gameRound;

    public RacingGame(String carNames, String gameRound) {
        setUpCars(carNames);
        setUpRound(gameRound);
        startGame();
    }

    public void setUpCars(String carNames) {
        this.cars = new Cars(carNames);
    }

    public void setUpRound(String gameRound) {
        this.gameRound = new GameRound(gameRound);
    }

    public void startGame() {
        for (int i = ZERO; i < gameRound.getGameRound(); i++) {
            cars.moveAll();
            OutputView.printCurrentRound(cars.getCars());
        }
    }

    public String getResult() {
        return cars.getResult();
    }
}
