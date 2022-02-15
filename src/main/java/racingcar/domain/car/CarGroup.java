package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.car.validator.CarGroupValidator;
import racingcar.service.picker.NumberPicker;

public class CarGroup {

    private final List<Car> cars = new ArrayList<>();

    public CarGroup(List<String> names) {
        names.forEach(name -> cars.add(new Car(name)));
        CarGroupValidator.validateNames(names);
    }

    public void goForwardOrStop(NumberPicker numberPicker) {
        cars.stream()
            .filter(car -> car.isPossibleToGoForward(numberPicker.pickNumber()))
            .forEach(Car::goForward);
    }

    public List<CarStatusDto> getStatuses() {
        return cars.stream()
                .map(CarStatusDto::toDto)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getWinnerNames() {
        int farthestLocation = getFarthestLocation();
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
