package racingcar.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class RacingcarService {

    private final List<Car> cars;

    public RacingcarService(String inputNames) {
        this.cars = CarFactory.makeCars(inputNames);
    }

    public List<Car> move() {
        for (Car car : cars) {
            car.move(RandomMaker.random());
        }
        return Collections.unmodifiableList(cars);
    }

    public List<Car> findWinners() {
        int winnerPosition = findPosition();

        return cars.stream()
                .filter(car -> car.isPosition(winnerPosition))
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
