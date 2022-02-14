package racingcar.domain;

import racingcar.utils.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class Cars {

    private final List<Car> cars;
    private final List<String> winners;

    public Cars(String[] values) {
        cars = new ArrayList<>();
        winners = new ArrayList<>();
        for (String value : values) {
            cars.add(new Car(value));
        }
    }

    public void moveCars(NumberGenerator generator) {
        for (Car car : cars) {
            car.goForward(generator.generate());
        }
    }

    public List<String> findWinners() {
        int maxPosition = getMaxPosition();
        addWinnerNames(maxPosition);
        return winners;
    }

    private void addWinnerNames(int position) {
        cars.stream()
            .filter(car -> car.getPosition() == position)
            .forEach(car -> winners.add(car.getName()));
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
