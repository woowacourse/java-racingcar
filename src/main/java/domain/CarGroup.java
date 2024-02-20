package domain;

import dto.CarDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {
    private final List<Car> cars;

    public CarGroup(final String[] carNames) {
        this.cars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<CarDto> getWinners() {
        final int positionMax = getPositionMax();

        if (positionMax == 0) {
            return List.of();
        }

        return cars.stream()
                .filter(car -> car.isPositionedAt(positionMax))
                .map(CarDto::toDto)
                .toList();
    }

    private int getPositionMax() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

}
