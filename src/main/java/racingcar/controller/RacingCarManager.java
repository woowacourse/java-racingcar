package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Winner;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarManager {
    private static final int MAX_BOUND = 10;

    private final InputManager inputManager;
    private List<Car> cars;
    private int gameCount;

    public RacingCarManager(final InputManager inputManager) {
        cars = new ArrayList<>();
        gameCount = 0;
        this.inputManager = inputManager;
    }

    public void playRacingGame() {
        getGameInformation();
        startRacing();
        endRacing();
    }

    private void endRacing() {
        Winner winner = getRacingWinners();
        printWinners(winner);
    }

    private void printWinners(Winner winner) {
        OutputView.printCarWinners(winner);
    }

    private Winner getRacingWinners() {
        return new Winner(cars);
    }

    private void getGameInformation() {
        cars = inputManager.getRacingCar();
        gameCount = inputManager.getGameCount();
    }

    private void startRacing() {
        OutputView.printResultMent();
        for (int i = 0; i < gameCount; i++) {
            moveRacingCar();
        }
    }

    private void moveRacingCar() {
        for (Car car : cars) {
            car.move(getRandomNumber());
            OutputView.printCarPosition(car);
        }
        OutputView.printEmptyLine();
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

}
