package racingCar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import racingCar.domain.dto.CarsDto;
import racingCar.domain.moveStrategy.NumGenerator;
import racingCar.exception.name.NameDuplicatedException;
import racingCar.exception.name.NameOnlyOneException;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> cars) {
        validate(cars);
        for (String car : cars) {
            this.cars.add(new Car(car, 0));
        }
    }

    private static void validate(List<String> cars) {
        if (cars.size() <= 1) {
            throw new NameOnlyOneException();
        }
        if (new HashSet<>(cars).size() != cars.size()) {
            throw new NameDuplicatedException();
        }
    }

    public void go(NumGenerator numGenerator) {
        for (Car car : cars) {
            car.move(numGenerator);
        }
    }

    public int getMaxPosition() {
        return Collections.max(cars).getPosition();
    }

    public CarsDto getSamePositionCarsDto(int position) {
        return CarsDto.fromCars(cars.stream()
                .filter(car -> car.isThatPosition(position))
                .collect(Collectors.toList()));
    }

    public CarsDto toDto() {
        return CarsDto.fromCars(cars);
    }
}