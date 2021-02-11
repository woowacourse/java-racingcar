package racingcar.domain;

import racingcar.utils.RandomUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private static final int MINIMUM_CAR_AMOUNT = 2;
    private static final String CAR_AMOUNT_LACK_ERROR_MESSAGE = "자동차는 두 대 이상이어야 합니다.";
    private static final String CAR_NAME_DUPLICATION_ERROR_MESSAGE = "자동차의 이름은 중복되지 않아야 합니다.";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarAmount(cars);
        validateCarNameDuplication(cars);
        this.cars = cars;
    }

    public void raceOneLap() {
        cars.forEach(car -> car.moveForwardByNumber(RandomUtil.generateRandomNumber()));
    }

    public Map<String, Integer> getStatus() {
        Map<String, Integer> carStatus = new HashMap<>();
        cars.forEach(car -> carStatus.put(car.getName(), car.getPosition()));
        return carStatus;
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = getMaxPositionCar(maxPosition);

        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<Car> getMaxPositionCar(int maxPosition) {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .collect(Collectors.summarizingInt(Car::getPosition))
                .getMax();
    }

    private void validateCarAmount(List<Car> cars) {
        if (cars.size() < MINIMUM_CAR_AMOUNT) {
            throw new IllegalArgumentException(CAR_AMOUNT_LACK_ERROR_MESSAGE);
        }
    }

    private void validateCarNameDuplication(List<Car> cars) {
        Set<Car> carsWithoutDuplication = new HashSet<>(cars);
        if (carsWithoutDuplication.size() != cars.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATION_ERROR_MESSAGE);
        }
    }
}