package racingcar.model.firstcollection;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import racingcar.model.RandomUtil;
import racingcar.model.vo.Car;

public class Cars {
    private final List<Car> cars;
    public static final String MESSAGE_FOR_CAR_NAME_DUPLICATE = "이름은 중복될 수 없습니다.";

    public Cars(List<Car> cars) {
        validateDuplicate(cars);
        this.cars = cars;
    }

    private static void validateDuplicate(List<Car> cars) {
        if (duplicateCarNames(cars)) {
            throw new IllegalArgumentException(MESSAGE_FOR_CAR_NAME_DUPLICATE);
        }
    }

    private static boolean duplicateCarNames(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toSet())
                .size() != cars.size();
    }

    public void move() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).advance(getRandomNumber());
        }
    }

    private int getRandomNumber() {
        return RandomUtil.getNumbersInRange(10);
    }

    public List<String> getWinner() {
        return getWinnerNames(getMaxPosition());
    }

    private int getMaxPosition() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(NoSuchElementException::new)
                .getPosition();
    }

    private List<String> getWinnerNames(int maxPosition) {
        return cars.stream()
                .filter(car -> car.isEqualPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
