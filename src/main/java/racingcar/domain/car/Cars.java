package racingcar.domain.car;

import racingcar.domain.game.Winners;
import racingcar.exception.EmptyCarException;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

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
                .map(CarState::withNameAndPosition)
                .collect(Collectors.toList());

        return CarStates.valueOf(carStates);
    }

    public Winners getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        return new Winners(cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .map(Car::getName)
                .sorted()
                .collect(Collectors.toList()));
    }

    public void move() {
        cars.forEach(Car::move);
    }
}