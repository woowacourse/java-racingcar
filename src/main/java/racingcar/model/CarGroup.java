package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.utils.RandomNumberGenerator;

public class CarGroup {
    private final List<Car> cars = new ArrayList<>();

    public void add(Car car) {
        cars.add(car);
    }

    public Map<String, Integer> race() {
        Map<String, Integer> raceResponse = new HashMap<>();
        for (Car car : cars) {
            int nextPosition = car.move(RandomNumberGenerator.generate());
            raceResponse.put(car.getName(), nextPosition);
        }

        return raceResponse;
    }

    public List<String> findWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter((car -> car.isMoved() && car.isSamePosition(maxPosition)))
                .map(Car::getName)
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
