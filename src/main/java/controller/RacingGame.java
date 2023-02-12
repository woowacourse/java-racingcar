package controller;

import domain.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import utils.RandomNumberGenerator;
import view.ResultView;

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

    private void initCars(String[] carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
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
