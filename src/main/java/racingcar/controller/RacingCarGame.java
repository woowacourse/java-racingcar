package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.GameTurn;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private Cars cars;
    private GameTurn gameTurn;

    public void makeCars() {
        cars = new Cars(inputView.getCarNames());
    }

    public void saveGameTurn() {
        try {
            int gameTurn = inputView.getGameTurn();
            this.gameTurn = new GameTurn(gameTurn);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            saveGameTurn();
        }
    }

    public void moveCars() {
        outputView.printResultSentence();
        while (gameTurn.isPositive()) {
            gameTurn.removeTurn();
            cars.moveCars();
            outputView.printResult(cars.getPosition());
        }
    }

    public void printWinners() {
        outputView.printWinners(cars.findWinnerCars());
    }
}
