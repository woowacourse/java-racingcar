package racingCar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import racingCar.domain.exception.name.NameDuplicatedException;
import racingCar.domain.exception.name.NameOnlyOneException;
import racingCar.domain.utils.Util;

public class RacingCars {
    private final List<Car> cars = new ArrayList<>();

    public RacingCars(List<String> cars) {
        validate(cars);
        for (String car : cars) {
            this.cars.add(new Car(car, 0));
        }
    }

    public void go() {
        for (Car car : cars) {
            car.go(Util.getRandomInteger());
        }
    }

    public int getMaxPosition() {
        ArrayList<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition().get());
        }
        return Collections.max(positions);
    }

    private static void validate(List<String> cars) {
        if (cars.size() <= 1) {
            throw new NameOnlyOneException();
        }
        if (new HashSet<>(cars).size() != cars.size()) {
            throw new NameDuplicatedException();
        }
    }

    public List<CarDTO> getSamePositionCars(int position) {
        return get().stream()
                .filter(car -> car.position == position)
                .collect(Collectors.toList());
    }

    public List<CarDTO> get() {
        List<CarDTO> carDTOs = new ArrayList<>();
        for (Car car : cars) {
            carDTOs.add(new CarDTO(car));
        }
        return carDTOs;
    }
}