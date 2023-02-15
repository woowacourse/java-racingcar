package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<String> findWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        for (Car car : cars) {
            addWinnerName(winnerNames, maxPosition, car);
        }
        return winnerNames;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private void addWinnerName(List<String> winnerNames, int maxPosition, Car car) {
        if (car.getPosition() == maxPosition) {
            winnerNames.add(car.getName());
        }
    }
}
