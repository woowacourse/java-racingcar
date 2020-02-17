package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;
    public static List<Car> winners = new ArrayList<>();

    public Cars(Names names) {
        this.cars = names.getNames()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        for (Car car : cars) {
            car.movePosition();
        }
    }

    public List<Car> selectWinners() {
        Car maxDistanceCar = cars.stream()
                .max(Car::compareTo)
                .get();
        winners = cars.stream()
                .filter(car -> car.isMaxPosition(maxDistanceCar))
                .collect(Collectors.toList());
        return Collections.unmodifiableList(winners);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}