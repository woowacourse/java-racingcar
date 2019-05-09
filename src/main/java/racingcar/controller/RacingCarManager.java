package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Winner;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarManager {
    private List<Car> cars;
    private int gameCount;

    public RacingCarManager() {
        cars = new ArrayList<>();
        gameCount = 0;
    }

    public void racingGameStart(InputManager inputManager) {
        getGameInformation(inputManager);
        startRacing();
        getRacingWinners();
    }

    private void getRacingWinners() {
        Winner winner = new Winner(cars);
        OutputView.printWinners(winner);
    }

    private void getGameInformation(InputManager inputManager) {
        cars = inputManager.getRacingCar();
        gameCount = inputManager.getGameCount();
    }

    private void startRacing() {
        for (int i = 0; i < gameCount; i++) {
            moveRacingCar();
        }
    }

    private void moveRacingCar() {
        for (Car car : cars) {
            car.move(getRandomNumber());
            OutputView.printCarState(car);
        }
        OutputView.printEmptyLine();
    }

    private int getRandomNumber() {
        return (int) (Math.random() * 10);
    }

}
