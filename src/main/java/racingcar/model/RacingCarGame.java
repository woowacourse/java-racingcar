package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class RacingCarGame {
    private static final String COMMA_DELIMITER = ",";

    private final Cars cars;
    private final GameTurn gameTurn;

    public RacingCarGame(String carNames, int gameTurn) {
        this.cars = Cars.of(splitCarNames(carNames), new RandomMovingStrategy());
        this.gameTurn = new GameTurn(gameTurn);
    }

    private List<String> splitCarNames(String carNames) {
        return Arrays.asList(carNames.split(COMMA_DELIMITER));
    }

    public boolean canRace() {
        return gameTurn.isPositive();
    }

    public void race() {
        gameTurn.removeTurn();
        cars.moveCars();
    }

    public List<String> getWinners() {
        return cars.findWinnerCars();
    }

    public List<String> getCarsPosition() {
        return cars.getPosition();
    }
}
