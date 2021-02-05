package racingcar.domain.car;

import racingcar.exception.EmptyCarException;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static List<Car> cars;

    private Cars(List<Car> cars) {
        validateEmptyCarList(cars);
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    private void validateEmptyCarList(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new EmptyCarException();
        }
    }

    public CarStates getCarStates() {
        List<CarState> carStates = cars.stream()
                .map(car -> CarState.withNameAndPosition(car.getName(), car.getPosition()))
                .collect(Collectors.toList());

        return CarStates.of(carStates);
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

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }
}

