package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.GameTurn;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    private Cars cars;
    private GameTurn gameTurn;

    public void makeCars() {
        cars = new Cars(InputView.getCarNames());
    }

    public void saveGameTurn() {
        try {
            int gameTurn = InputView.getGameTurn();
            this.gameTurn = new GameTurn(gameTurn);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            saveGameTurn();
        }
    }

    public void moveCars() {
        OutputView.printResultSentence();
        while (gameTurn.isPositive()) {
            gameTurn.removeTurn();
            cars.moveCars();
            OutputView.printResult(cars.getPosition());
        }
    }

    public void printWinners() {
        OutputView.printWinners(cars.findWinnerCars());
    }
}
