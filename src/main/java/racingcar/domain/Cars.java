package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private static final Cars instance = new Cars();

    private List<Car> cars = new ArrayList<>();

    private Cars() {
    }

    public static Cars getInstance() {
        return instance;
    }

    public void insertCar(Car car) {
        cars.add(car);
    }

    public void insertCarFromCarNames(String[] carNames) {
        for (String carName : carNames) {
            insertCar(new Car(carName, new RandomNumberGenerator()));
        }
    }

    public int carCount() {
        return cars.size();
    }

    public void moveRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    public String[] getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toArray(String[]::new);
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void removeAll() {
        cars.clear();
    }
}
