package racingCar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import racingCar.model.exception.name.NameDuplicatedException;
import racingCar.model.exception.name.NameOnlyOneException;
import racingCar.model.utlis.Util;

public class RacingCars {
    private final List<Car> cars = new ArrayList<>();

    public RacingCars(List<String> cars) {
        validate(cars);
        for (String car : cars) {
            this.cars.add(new Car(car));
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

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public void go() {
        for (Car car : cars) {
            car.go();
        }
    }

    public int getMaxPosition() {
        ArrayList<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.position.get());
        }
        return Util.getMax(positions);
    }

    public List<Car> getSamePositionCars(int position) {
        return cars.stream()
                .filter(car -> car.position.isSame(position))
                .collect(Collectors.toList());
    }

    public List<Car> get() {
        return cars;
    }
}