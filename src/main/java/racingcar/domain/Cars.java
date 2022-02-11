package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.util.NumberGeneratePolicy;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carsName) {
        this.cars = carsName.stream()
            .map(carName -> new Car(carName))
            .collect(Collectors.toList());
    }

    public static Cars from(List<String> carsName) {
        return new Cars(carsName);
    }

    public void driveAll(NumberGeneratePolicy numberGeneratePolicy) {
        cars.forEach(car -> car.drive(numberGeneratePolicy.generateNumber()));
    }

    public List<Car> getDriveRecord() {
        return Collections.unmodifiableList(cars);
    }
}
