package racingcar.model;

import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {

    private static final int DEFAULT_POSITION = 0;

    private final List<Car> cars;

    public Cars(final String[] carNames) {
        this.cars = new ArrayList<>();
        insertCarFromCarNames(carNames);
    }

    private void insertCarFromCarNames(final String[] carNames) {
        for (String carName : carNames) {
            insertCar(new Car(carName, DEFAULT_POSITION));
        }
    }

    private void insertCar(final Car car) {
        cars.add(car);
    }

    public void moveRound() {
        for (Car car : cars) {
            car.move(new RandomNumberGenerator());
        }
    }

    public Map<String, Integer> getPositionResult() {
        return cars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getPosition));
    }

    public List<String> getWinner() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    public List<Car> getCars() {
        return cars;
    }
}
