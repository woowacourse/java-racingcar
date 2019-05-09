package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class RacingCarManager {
    private List<Car> cars;
    private int gameCount;
    private InputManager inputManager;

    public RacingCarManager() {
        cars = new ArrayList<>();
        gameCount = 0;
        inputManager = new InputManager();
    }

    public void racingGameStart() {
        getGameInformation();
        startRacing();
    }

    private void getGameInformation() {
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
    }

    private int getRandomNumber() {
        return (int) Math.random() * 10;
    }

}
