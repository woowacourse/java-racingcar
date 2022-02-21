package carracing.model;

import carracing.dto.CarDto;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import carracing.utils.RandomMove;
import carracing.utils.MoveStrategy;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.isEqualPosition(maxPosition))
                .map(Car::toCarDto)
                .map(CarDto::getName)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        MoveStrategy moveStrategy = new RandomMove();
        cars.forEach(car -> car.move(moveStrategy));
    }

    private int getMaxPosition() {
        return cars.stream()
                .sorted()
                .findFirst()
                .orElseThrow(NoSuchElementException::new)
                .toCarDto()
                .getPosition();
    }

    public List<CarDto> getCarsStatus() {
        return cars.stream()
                .map(Car::toCarDto)
                .collect(Collectors.toList());
    }
}
