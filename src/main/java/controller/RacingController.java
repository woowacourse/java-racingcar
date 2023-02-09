package controller;

import domain.Car;
import domain.NumberGenerator;
import domain.RacingGame;
import utils.Log;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public RacingController(NumberGenerator numberGenerator) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        List<Car> cars = generateCars();
        int gameTrial = generateGameTrial();
        RacingGame racingGame = new RacingGame(cars, gameTrial, numberGenerator);
        play(racingGame);
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

    private int generateGameTrial() {
        try {
            return inputView.readGameTrial();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return generateGameTrial();
        }
    }
}