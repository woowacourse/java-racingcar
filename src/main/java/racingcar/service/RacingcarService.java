package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class RacingcarService {

    private static final int MINIMUM_PARTICIPANT = 2;
    private final List<Car> cars;

    public RacingcarService(List<String> carNames) {
        if (carNames.size() < MINIMUM_PARTICIPANT) {
            throw new IllegalArgumentException("[ERROR] 경주는 최소 " + MINIMUM_PARTICIPANT + "명이 필요해요.");
        }
        this.cars = CarFactory.makeCars(carNames);
    }

    public List<String> move() {
        for (Car car : cars) {
            car.move(RandomMaker.random());
        }

        return cars.stream()
                .map(Car::printCar)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> findWinners() {
        int winnerPosition = findPosition();

        return cars.stream()
                .filter(car -> car.isPosition(winnerPosition))
                .map(Car::printCar)
                .collect(Collectors.toUnmodifiableList());
    }

    private int findPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = car.findGreaterPosition(maxPosition);
        }

        return maxPosition;
    }
}
