package controller;

import domain.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import utils.RandomNumberGenerator;
import view.ResultView;

public class RacingGame {
    private final List<Car> cars;
    private int tryCount;

    public RacingGame(String[] carNames, int tryCount) {
        this.cars = generateCars(carNames);
        this.tryCount = tryCount;
    }

    public void start() {
        System.out.println("실행 결과");
        while (!isEnd()) {
            moveCars();
            ResultView.printPositionOfCars(cars);
            System.out.println();
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private List<Car> generateCars(String[] carNames) {
        final List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private boolean isEnd() {
        if (tryCount > 0) {
            tryCount--;
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

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max().orElse(0);
    }
}
