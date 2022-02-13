package racingcar.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;

public class CarStatus {

    private final List<Car> cars;

    public CarStatus(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public String makeCarsStatus() {
        return cars.stream()
            .map(CarStatus::makeCarStatus)
            .collect(joining("\n"));
    }

    private static String makeCarStatus(Car car) {
        StringBuilder carStatus = new StringBuilder(car.getName());
        carStatus.append(" : ");
        int position = car.getPosition();
        while (position-- > 0) {
            carStatus.append("-");
        }
        return carStatus.toString();
    }
}
