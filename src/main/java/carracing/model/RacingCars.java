package carracing.model;

import static carracing.view.messages.ExceptionMessage.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import carracing.utils.RandomMove;
import carracing.utils.MoveStrategy;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        validateDuplication(cars);

        this.cars = cars;
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.isEqualTo(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        MoveStrategy moveStrategy = new RandomMove();
        cars.forEach(car -> car.move(moveStrategy));
    }

    private void validateDuplication(List<Car> cars) {
        boolean isDuplicated = cars.stream()
                .map(Car::getName)
                .distinct()
                .count() != cars.size();

        if (isDuplicated) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_EXCEPTION.getMessage());
        }
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Car> getCars() {
        return cars;
    }
}
