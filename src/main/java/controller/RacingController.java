package controller;

import domain.Car;
import domain.NumberGenerator;
import domain.RacingGame;
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
        showWinner(racingGame);
    }

    private void showWinner(RacingGame racingGame) {
        outputView.showWinner(racingGame.getWinners());
    }

    private List<Car> generateCars() {
        return inputView.readCars()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private int generateGameTrial() {
        return inputView.readGameTrial();
    }
}