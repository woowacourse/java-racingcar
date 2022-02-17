package racingcar.model;

import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int DEFAULT_POSITION = 0;

    private List<Car> cars;

    public Cars(final String[] carNames) {
        this.cars = new ArrayList<>();
        insertCarFromCarNames(carNames);
    }

    private void insertCarFromCarNames(final String[] carNames) {
        for (String carName : carNames) {
            insertCar(new Car(carName, DEFAULT_POSITION));
        }
    }

    public void insertCar(final Car car) {
        cars.add(car);
    }

    public List<Car> getRacingCars() {
        return cars;
    }

    public void moveRound() {
        for (Car car : cars) {
            car.move(new RandomNumberGenerator());
        }
    }

    public List<String> getWinner() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        return cars.stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
