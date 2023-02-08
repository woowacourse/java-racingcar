package controller;

import domain.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import utils.RandomNumberGenerator;

public class RacingGame {
    private List<Car> cars;
    private int tryCount;

    public RacingGame(String[] carNames, int tryCount) {
        initCars(carNames);
        this.tryCount = tryCount;
    }

    public void start() {
        System.out.println("실행 결과");
        while (!isEnd()) {
            moveCars();
            printPositionOfCars();
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private void initCars(String[] carNames) {
        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

    private boolean isEnd() {
        if (this.tryCount > 0) {
            this.tryCount--;
            return false;
        }
        return true;
    }

    private void moveCars() {
        for (Car car : cars) {
            int power = RandomNumberGenerator.getPower();
            car.move(power);
        }
    }

    private void printPositionOfCars() {
        for (Car car : cars) {
            System.out.printf("%s : %s%n", car.getName(), "-".repeat(car.getPosition()));
        }
    }

    private int getMaxPosition() {
        return this.cars.stream()
                .mapToInt(Car::getPosition)
                .max().orElse(0);
    }
}
