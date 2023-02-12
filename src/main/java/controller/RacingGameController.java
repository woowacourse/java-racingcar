package controller;

import domain.*;
import utils.Log;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    public void run() {
        RacingGame racingGame = init();
        play(racingGame);
    }

    private RacingGame init() {
        List<Car> cars = generateCars();
        GameTrialCount gameTrialCount = generateGameTrial();
        return new RacingGame(cars, gameTrialCount, numberGenerator);
    }

    private void play(RacingGame racingGame) {
        outputView.showInfoMessage();
        while (racingGame.canContinue()) {
            List<Car> cars = racingGame.run();
            outputView.showCars(cars);
        }
        outputView.showWinner(racingGame.getWinners());
    }

    private List<Car> generateCars() {
        try {
            return inputView.readCars()
                    .stream()
                    .map(Car::new)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return generateCars();
        }
    }

    private GameTrialCount generateGameTrial() {
        try {
            return new GameTrialCount(inputView.readGameTrial());
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return generateGameTrial();
        }
    }
}