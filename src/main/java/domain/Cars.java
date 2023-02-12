package domain;

import validation.ErrorMessage;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicateCars(cars);
        this.cars = cars;
    }

    private void validateDuplicateCars(List<Car> cars) {
        Set<Car> carSet = new HashSet<>();
        cars.forEach(carSet::add);

        if (cars.size() != carSet.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
        }
    }

    public void move(NumberGenerator numberGenerator) {
        cars.stream()
                .filter(car -> car.canMove(numberGenerator.generate()))
                .forEach(Car::move);
    }

    public List<Car> getWinners() {
        int maxCount = getMaxMoveCount();
        return cars.stream()
                .filter(car -> car.isWinner(maxCount))
                .collect(Collectors.toUnmodifiableList());
    }

    private int getMaxMoveCount() {
        return cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .getAsInt();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
