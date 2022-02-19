package racingcar.domain;

import static racingcar.util.StringUtils.splitByDelimiter;
import static racingcar.util.StringUtils.stripStringArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.message.ErrorMessages;
import racingcar.util.RandomUtils;

public class Cars {
    private static final String DELIMITER = ",";
    private static final int MIN = 0;
    private static final int MAX = 9;

    private final List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        String[] carNameArray = stripStringArray(splitByDelimiter(carNames, DELIMITER));
        validateDuplicatedName(carNameArray);
        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            car.go(RandomUtils.generateNumber(MIN, MAX + 1));
        }
    }

    public Winners getWinners() {
        return new Winners(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validateDuplicatedName(String[] carNames) {
        long distinctSize = Arrays.stream(carNames)
                .distinct().count();
        if (distinctSize != carNames.length) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATED_NAME);
        }
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
