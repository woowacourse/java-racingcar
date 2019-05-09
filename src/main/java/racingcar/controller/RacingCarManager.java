package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

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
        moveRacingCar();
    }

    private void getGameInformation() {
        cars = inputManager.getRacingCar();
        gameCount = inputManager.getGameCount();
    }

    private void moveRacingCar() {
        for (Car car : cars) {
            car.move(getRandomNumber());
        }
    }

    private int getRandomNumber() {
        return (int) Math.random() * 10;
    }
}
