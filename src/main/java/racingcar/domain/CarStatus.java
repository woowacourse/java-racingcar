package racingcar.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;

public class CarStatus {
    private static final String CARS_STATUS_JOIN_DELIMITER = "\n";
    private static final String CAR_STATUS_CRITERIA = " : ";
    private static final String CAR_STATUS_POSITION = "-";

    private final List<Car> cars;

    public CarStatus(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public String makeCarsStatus() {
        return cars.stream()
            .map(CarStatus::makeCarStatus)
            .collect(joining(CARS_STATUS_JOIN_DELIMITER));
    }

    private static String makeCarStatus(Car car) {
        StringBuilder carStatus = new StringBuilder(car.getName());
        carStatus.append(CAR_STATUS_CRITERIA);
        int position = car.getPosition();
        while (position-- > 0) {
            carStatus.append(CAR_STATUS_POSITION);
        }
        return carStatus.toString();
    }
}
