package racingcar.controller;

import racingcar.domain.Car;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final String RESULT_PREFIX = "실행결과";

    private List<Car> cars = new ArrayList<>();
    private final int tryCount;

    public RacingGame(String[] carNames, int tryCount) {
        this.tryCount = tryCount;
        insertCarFromCarNames(carNames);
    }

    public void play() throws RuntimeException {
        OutputView.printMessage(RESULT_PREFIX);
        for (int i = 0; i < tryCount; i++) {
            moveRound();
            printPosition();
        }
        printWinner();
    }

    public void insertCar(Car car) {
        cars.add(car);
    }

    public void insertCarFromCarNames(String[] carNames) {
        for (String carName : carNames) {
            insertCar(new Car(carName, new RandomNumberGenerator()));
        }
    }

    public int carCount() {
        return cars.size();
    }

    private void moveRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    public String[] getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toArray(String[]::new);
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    private void printPosition() {
        OutputView.printResult(cars);
    }

    private void printWinner() {
        OutputView.printWinner(getWinners());
    }
}
