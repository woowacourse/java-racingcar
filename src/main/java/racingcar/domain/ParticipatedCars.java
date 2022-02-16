package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import racingcar.util.BoundedRandomNumberGenerator;

public class ParticipatedCars {
    private static final int MAX_BOUND = 9;
    private static final int MIN_BOUND = 0;

    private final List<Car> cars = new ArrayList<>();

    public void generateCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public WinnerNames findWinners() {
        return getWinnerNamesWithFirstCar(findFastestCar());
    }

    private WinnerNames getWinnerNamesWithFirstCar(Car firstCar) {
        return WinnerNames.of(this, firstCar);
    }

    private Car findFastestCar() {
        Collections.sort(cars);
        return cars.get(this.getSize()-1);
    }

    public List<String> executeCarRacing() {
        List<String> racingRecord = new ArrayList<>();
        for (Car car : cars) {
            car.tryMovingBy(new BoundedRandomNumberGenerator(MAX_BOUND, MIN_BOUND));
            racingRecord.add(car.toString());
        }
        return racingRecord;
    }

    public int getSize() {
        return cars.size();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
