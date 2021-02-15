package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.game.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {

    private Game game;
    private Cars cars;

    public void run() {
        initializeGame();
        play();
    }

    private void initializeGame() {
        registerCars();
        registerRounds();
    }

    private void registerCars() {
        try {
            cars = new Cars(InputView.inputNames());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            registerCars();
        }
    }

    private void registerRounds() {
        try {
            game = new Game(InputView.inputRound());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e);
            registerRounds();
        }
    }

    private void play() {
        OutputView.printResultTitle();
        while (game.notFinished()) {
            cars.moveIndividuals();
            game.play();
            OutputView.printRoundResult(cars);
        }
        OutputView.printFinalResult(cars.collectWinners());
    }
}
