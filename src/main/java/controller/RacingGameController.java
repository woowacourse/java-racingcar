package controller;

import domain.*;
import utils.Log;
import view.InputView;
import view.OutputView;

import java.util.stream.Collectors;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.numberGenerator = new RandomNumberGenerator();
    }

    public void run() {
        RacingGame racingGame = init();
        play(racingGame);
    }

    private RacingGame init() {
        Cars cars = generateCars();
        int gameTrial = generateGameTrial();
        return new RacingGame(cars, gameTrial, numberGenerator);
    }

    private void play(RacingGame racingGame) {
        outputView.showInfoMessage();
        while (racingGame.canContinue()) {
            Cars cars = racingGame.run();
            outputView.showCars(cars.getCars());
        }
        outputView.showWinner(racingGame.getWinners());
    }

    private Cars generateCars() {
        try {
            return new Cars(inputView.readCarNames()
                    .stream()
                    .map(Car::new)
                    .collect(Collectors.toList()));
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return generateCars();
        }
    }

    private int generateGameTrial() {
        try {
            return inputView.readGameTrial();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return generateGameTrial();
        }
    }
}
