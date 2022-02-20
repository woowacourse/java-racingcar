package racingcar.utils;

import racingcar.exception.DuplicateCarNameException;
import racingcar.exception.LessThanMinimumCountException;
import racingcar.exception.LessThanMinimumPlayerException;
import racingcar.model.Car;

import java.util.HashSet;
import java.util.List;

public class Validator {

    private static final int MINIMUM_COUNT = 1;
    private static final int MINIMUM_PLAYER_SIZE = 2;

    private Validator() {
        throw new UnsupportedOperationException();
    }

    public static void validateCarFollowsRule(List<Car> cars) {
        checkDuplicateName(cars);
        checkMinimumPlayer(cars);
    }

    public static void validateRange(int count) {
        checkMinimumRange(count);
    }

    private static void checkMinimumRange(int count) {
        if (count < MINIMUM_COUNT) {
            throw new LessThanMinimumCountException(MINIMUM_COUNT);
        }
    }

    private static void checkDuplicateName(List<Car> cars) {
        if (hasDuplicateName(cars)) {
            throw new DuplicateCarNameException();
        }
    }

    private static void checkMinimumPlayer(List<Car> cars) {
        if (cars.size() < MINIMUM_PLAYER_SIZE) {
            throw new LessThanMinimumPlayerException(MINIMUM_PLAYER_SIZE);
        }
    }

    private static boolean hasDuplicateName(List<Car> cars) {
        HashSet<Car> distinct = new HashSet<>(cars);
        return distinct.size() != cars.size();
    }
}
