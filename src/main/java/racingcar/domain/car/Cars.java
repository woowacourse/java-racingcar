package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.car.strategy.MoveStrategy;
import racingcar.domain.car.validator.CarsValidator;
import racingcar.dto.CarStatusDto;

public class Cars {

    private final List<Car> cars = new ArrayList<>();
    private final MoveStrategy moveStrategy;

    public Cars(final List<String> names, final MoveStrategy moveStrategy) {
        names.forEach(name -> cars.add(new Car(name)));
        CarsValidator.validateNames(names);
        this.moveStrategy = moveStrategy;
    }

    public void goForwardOrStop() {
        cars.forEach(car -> car.goForward(moveStrategy));
    }

    public List<CarStatusDto> getStatuses() {
        return cars.stream()
                .map(CarStatusDto::toDto)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getWinnerNames() {
        final int farthestLocation = getFarthestLocation();
        return cars.stream()
                .filter(car -> car.isLocationSameWith(farthestLocation))
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private int getFarthestLocation() {
        return Collections.max(this.getCurrentLocations());
    }

    private List<Integer> getCurrentLocations() {
        return cars.stream()
                .map(Car::getLocation)
                .collect(Collectors.toUnmodifiableList());
    }

}
