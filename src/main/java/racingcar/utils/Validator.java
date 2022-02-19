package racingcar.utils;

import racingcar.exception.DuplicateCarNameException;
import racingcar.exception.InvalidCountRangeException;
import racingcar.exception.SingleCarException;
import racingcar.model.Car;

import java.util.HashSet;
import java.util.List;

public class Validator {

    private static final int MINIMUM_COUNT = 1;
    private static final int MINIMUM_PLAYER = 2;

    private Validator() {
        throw new UnsupportedOperationException();
    }

    public static void validate(List<Car> cars) {
        checkDuplicateName(cars);
        checkMinimumPlayer(cars);
    }

    public static void validate(int count) {
        checkMinimumRange(count);
    }

    private static void checkMinimumRange(int count) {
        if (count < MINIMUM_COUNT) {
            throw new InvalidCountRangeException("시도 횟수는 1 이상이어야 합니다");
        }
    }

    private static void checkDuplicateName(List<Car> cars) {
        if (hasDuplicateName(cars)) {
            throw new DuplicateCarNameException("차 이름은 중복될 수 없습니다");
        }
    }

    private static void checkMinimumPlayer(List<Car> cars) {
        if (cars.size() < MINIMUM_PLAYER) {
            throw new SingleCarException("최소 자동차 개수는 2개 이상입니다");
        }
    }

    private static boolean hasDuplicateName(List<Car> cars) {
        HashSet<Car> distinct = new HashSet<>(cars);
        return distinct.size() != cars.size();
    }
}
