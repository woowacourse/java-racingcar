package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.car.validator.CarNameValidator;
import racingcar.service.picker.NumberPicker;

public class CarCollection {

    private final List<Car> cars = new ArrayList<>();

    public CarCollection(List<String> names) {
        CarNameValidator.validateNames(names);
        names.forEach(name -> cars.add(new Car(name)));
    }

    public void goForwardOrStop(NumberPicker numberPicker) {
        cars.stream()
            .filter(car -> car.isPossibleToGoForward(numberPicker.pickNumber()))
            .forEach(Car::goForward);
    }

    public List<CarStatusDto> getStatuses() {
        return cars.stream()
                .map(CarStatusDto::toDto)
                .collect(Collectors.toList());
    }

    public List<String> getWinnerNames() {
        int farthestLocation = getFarthestLocation();
        return cars.stream()
            .filter(car -> car.isLocationSameWith(farthestLocation))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private int getFarthestLocation() {
        return Collections.max(
            cars.stream().map(Car::getLocation).collect(Collectors.toList())
        );
    }

}
