package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(Names names) {
        this.cars = names.getNames()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars(int randomValue) {
        for (Car car : cars) {
            car.movePosition(randomValue);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}