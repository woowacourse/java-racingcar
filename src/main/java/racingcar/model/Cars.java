package racingcar.model;

import static racingcar.util.StringUtils.splitByDelimiter;
import static racingcar.util.StringUtils.stripStringArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.message.ErrorMessages;
import racingcar.util.RandomGenerator;

public class Cars {
    private static final String DELIMITER = ",";
    private static final String NEW_LINE = System.lineSeparator();
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
            car.goOrStop(RandomGenerator.generateNumber(MIN, MAX + 1));
        }
    }

    public Winners getWinners() {
        return new Winners(cars);
    }

    public String getCarsStatus() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.getCarStatus())
                    .append(NEW_LINE);
        }
        return stringBuilder.toString();
    }

    private void validateDuplicatedName(String[] carNames) {
        long distinctSize = Arrays.stream(carNames)
                .distinct().count();
        if (distinctSize != carNames.length) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATED_NAME);
        }
    }
}
