package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import racingcar.utils.generator.NumberGenerator;
import racingcar.utils.generator.RandomNumberGenerator;

public class Cars {
    private final List<Car> cars;
    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void forward() {
        for (Car car : cars) {
            car.forward(numberGenerator);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> findWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        int farthestPosition = getFarthestPosition();

        for (Car car : cars) {
            addWinnerNames(winnerNames, farthestPosition, car);
        }
        return Collections.unmodifiableList(winnerNames);
    }

    private void addWinnerNames(List<String> winnerNames, int farthestPosition, Car car) {
        if (car.isSamePositionWith(farthestPosition)) {
            winnerNames.add(car.getName());
        }
    }

    private int getFarthestPosition() {
        return cars.stream()
            .map(Car::getPosition)
            .max(Integer::compare)
            .orElse(-1);
    }
}
