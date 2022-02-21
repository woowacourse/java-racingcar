package racingcar.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class CarService {

    private static final String NAME_LENGTH_ERROR_MESSEAGE = "[ERROR] 자동차의 이름은 1글자 이상 5글자 이하여야 합니다.";
    private static final String NUMBER_RANGE_ERROR_MESSEAGE = "[ERROR] 시행 횟수는 1 이상 2,147,483,647 이하의 숫자만 가능합니다.";
    public static final int MAXIMUM_NAME_LENGTH = 5;
    public static final int MINIMUM_NAME_LENGTH = 1;

    public String[] splitCarNames(final String names) {
        return names.split(",");
    }

    public List<Car> race(final List<Car> cars) {
        Random random = new Random();
        return cars.stream()
                .map(c -> c.race(random.nextInt(10)))
                .collect(Collectors.toList());
    }

    public List<String> getWinners(final List<Car> cars) {
        final int max = getMaxPosition(cars);
        return cars.stream()
                .filter(c -> c.getPosition() == max)
                .map(c -> c.getName())
                .collect(Collectors.toList());
    }

    private int getMaxPosition(final List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(car.getPosition(), max);
        }
        return max;
    }

    public void checkValidateName(final String[] names) {
        checkEmptyName(names);
        for (final String name : names) {
            checkValidateNameLength(name);
        }
    }

    private void checkEmptyName(final String[] names) throws IllegalArgumentException {
        if (names.length == 0) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSEAGE);
        }
    }

    private void checkValidateNameLength(final String name) throws IllegalArgumentException {
        if (name.length() > MAXIMUM_NAME_LENGTH || name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSEAGE);
        }
    }

    public void checkValidateNumber(final String number) {
        try {
            final int racingCnt = Integer.parseInt(number);
            checkZeroOrNegative(racingCnt);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSEAGE);
        }
    }

    private void checkZeroOrNegative(final int racingCnt) {
        if (racingCnt <= 0) {
            throw new NumberFormatException();
        }
    }
}
