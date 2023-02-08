package service;

import domain.Car;
import domain.Cars;
import domain.Name;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public static Cars buildCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
            .map(
                carName -> new Car(new Name(carName))
            ).collect(Collectors.toList());
        return new Cars(cars);
    }

}
