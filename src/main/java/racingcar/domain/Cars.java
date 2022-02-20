package racingcar.domain;


import static racingcar.utils.RandomNumberGenerator.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final int START_POSITION = 0;

    private final List<Car> cars;

    public Cars(String[] carNames) {
        CarNameValidator.validateCarNames(carNames);
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, START_POSITION));
        }
    }

    public void startEachRace(int minBound, int maxBound) {
        for (Car car : cars) {
            car.move(generateRandomNumber(minBound, maxBound));
        }
    }

    public List<Car> findWinners() {
        int maxPosition = findMaxPosition();
        List<Car> winnerCars = new ArrayList<>();
        cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .forEach(winnerCars::add);
        return winnerCars;
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public int getSize() {
        return cars.size();
    }

    public List<CarDto> getCarDtos() {
        return this.cars.stream()
                .map(CarDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
