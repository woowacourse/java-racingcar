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

    private static List<Car> validateDuplicate(List<Car> cars) {
        if (duplicateCarNames(cars)) {
            throw new IllegalArgumentException(MESSAGE_FOR_CAR_NAME_DUPLICATE);
        }

        return cars;
    }

    private static boolean duplicateCarNames(List<Car> cars) {
        return cars.stream().map(Car::getName).collect(Collectors.toSet()).size() != cars.size();
    }

    public void move() {
        cars.forEach(car -> car.advance(RandomUtil.getNumbersInRange(10)));
    }

    public List<String> getWinner() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.isEqualPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(NoSuchElementException::new)
                .getPosition();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
