package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Winner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarManager {
    private static int MAX_BOUND = 10;
    private List<Car> cars;

    public RacingCarManager() {
        cars = new ArrayList<>();
    }

    public void playRacingGame(List<Car> getCars) {
        cars = getCars;
    }

    public Winner getRacingWinners() {
        return new Winner(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveRacingCar() {
        for (Car car : cars) {
            car.move(getRandomNumber());
        }
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

}
