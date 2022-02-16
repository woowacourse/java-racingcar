package racingcar.utils;

import racingcar.domain.Car;

import java.util.HashSet;
import java.util.List;

public class Validator {

    private static final int MINIMUM_COUNT = 1;

    public static void checkDuplicateName(List<Car> cars) {
        if (hasDuplicateName1(cars)) {
            throw new IllegalArgumentException("차 이름은 중복될 수 없습니다");
        }
    }

    public static void checkSinglePlayer(List<Car> cars) {
        if (cars.size() == 1) {
            throw new IllegalArgumentException("최소 자동차 개수는 2개 이상입니다");
        }
    }

    private static boolean hasDuplicateName1(List<Car> cars) {
        HashSet<Car> distinct = new HashSet<>(cars);
        return distinct.size() != cars.size();
    }

    public static void checkCountRange(int count) {
        if (count < MINIMUM_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다");
        }
    }
}
