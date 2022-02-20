package racingcar.domain;


import static racingcar.utils.RandomNumberGenerator.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    public static final String ERROR_ONLY_NAME = "[ERROR] 이름을 2개 이상 입력해주세요.";
    public static final String ERROR_DUPLICATE_NAME = "[ERROR] 중복된 이름이 있습니다.";

    public static final int START_POSITION = 0;

    private final List<Car> cars;

    public Cars(String[] carNames) {
        validateCarNames(carNames);
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, START_POSITION));
        }
    }

    private void validateCarNames(String[] splitCarNames) {
        checkOnlyName(splitCarNames);
        checkDuplicateName(splitCarNames);
    }

    private static void checkOnlyName(String[] names) {
        if (names.length == 1) {
            throw new IllegalArgumentException(ERROR_ONLY_NAME);
        }
    }

    private static void checkDuplicateName(String[] names) {
        Set<String> hashNames = new HashSet<>(Arrays.asList(names));
        if (hashNames.size() != names.length) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
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
