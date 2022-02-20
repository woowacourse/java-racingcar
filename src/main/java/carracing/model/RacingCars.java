package carracing.model;

import static carracing.view.messages.ExceptionMessage.*;

import carracing.dto.CarDto;
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
        Car maxPositionCar = getMaxPositionCar();

        return cars.stream()
                .filter(car -> car.isEqualPositionTo(maxPositionCar))
                .map(Car::toCarDto)
                .map(CarDto::getName)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        MoveStrategy moveStrategy = new RandomMove();
        cars.forEach(car -> car.move(moveStrategy));
    }

    private void validateDuplication(List<Car> cars) {
        boolean isDuplicated = cars.stream()
                .map(Car::toCarDto)
                .map(CarDto::getName)
                .distinct()
                .count() != cars.size();

        if (isDuplicated) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_EXCEPTION.getMessage());
        }
    }

    private Car getMaxPositionCar() {
        return cars.stream()
                .sorted()
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public List<CarDto> getCarsStatus() {
        return cars.stream()
                .map(Car::toCarDto)
                .collect(Collectors.toList());
    }
}
