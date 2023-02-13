package service;


import domain.Car;
import domain.Cars;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public static Cars buildCars(List<String> carNames) {
        return new Cars(
            carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList())
        );
    }
}
