package racingcar.model.firstcollection;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import racingcar.model.RandomUtil;
import racingcar.model.vo.Car;

public class Cars {
    private static final String MESSAGE_FOR_CAR_NAME_DUPLICATE = "이름은 중복될 수 없습니다.";
    private static final int RANGE_OF_ZERO_TO_NINE = 10;
    private static final String ERROR_MESSAGE_TO_GET_MAX_POSITION = "최대값을 구할 수 없습니다.";
    private static final String ERROR_MESSAGE_FOR_EMPTY_CAR_LIST = "자동차 목록을 확인해주세요";

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateNullOrEmpty(cars);
        List<Car> unmodifiableCars = List.copyOf(cars);
        validateDuplicate(unmodifiableCars);

        this.cars = unmodifiableCars;
    }

    private void validateNullOrEmpty(List<Car> cars) {
        if (Objects.isNull(cars) || cars.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_EMPTY_CAR_LIST);
        }
    }

    private static void validateDuplicate(final List<Car> cars) {
        if (duplicateCarNames(cars)) {
            throw new IllegalArgumentException(MESSAGE_FOR_CAR_NAME_DUPLICATE);
        }
    }

    private static boolean duplicateCarNames(final List<Car> cars) {
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
        return RandomUtil.getNumbersInRange(RANGE_OF_ZERO_TO_NINE);
    }

    public List<String> getWinner() {
        return getWinnerNames(getMaxPosition());
    }

    private int getMaxPosition() {
        OptionalInt max = cars.stream()
                            .mapToInt(Car::getPosition)
                            .max();

        if (max.isEmpty()) {
            throw new NoSuchElementException(ERROR_MESSAGE_TO_GET_MAX_POSITION);
        }

        return max.getAsInt();
    }

    private List<String> getWinnerNames(final int maxPosition) {
        return cars.stream()
                .filter(car -> car.isEqualPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
