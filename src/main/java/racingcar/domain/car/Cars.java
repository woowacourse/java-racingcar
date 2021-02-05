package racingcar.domain.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public CarStates getCarStates() {
        List<CarState> carStates = cars.stream()
                .map(car -> CarState.withNameAndPosition(car.getName(), car.getPosition()))
                .collect(Collectors.toList());

        return CarStates.of(carStates);
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<CarName> getWinners() {
       int maxPosition = cars.stream()
               .mapToInt(Car::getPosition)
               .max()
               .getAsInt();

       return cars.stream()
               .filter(car -> car.isSamePosition(maxPosition))
               .map(Car::getName)
               .collect(Collectors.toList());
    }
}

