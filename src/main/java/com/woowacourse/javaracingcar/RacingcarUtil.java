package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.Car;
import com.woowacourse.javaracingcar.domain.CarDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingcarUtil {
    private static final int MAX_NAME_LENGTH = 5;

    private RacingcarUtil() {}

    public static String joinCarNames(final List<CarDto> cars) {
        return cars.stream()
            .map(CarDto::getName)
            .collect(Collectors.joining(", "));
    }

    public static String[] splitIntoNames(final String commaSplittedNames) {
        final String[] names = commaSplittedNames.split(",");
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
        }
        return names;
    }

    public static boolean isValidNameInput(final String[] names) {
        try {
            checkEachOfNames(names);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static List<Car> createCars(final List<String> carNames) {
        final List<Car> cars = new ArrayList<>();
        for (String s : carNames) {
            cars.add(new Car(s));
        }

        return cars;
    }

    private static void checkEachOfNames(final String[] names) {
        for (String name : names) {
            checkIfNameIsEmpty(name);
            checkIfNameIncludesSpace(name);
            checkIfValidNames(name);
            checkIfNameDuplicates(name, names);
        }
    }

    private static void checkIfValidNames(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 넘을 수 없습니다");
        }
    }

    private static void checkIfNameIncludesSpace(final String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("이름에 공백을 포함할 수 없습니다");
        }
    }

    private static void checkIfNameIsEmpty(final String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름이 비어 있습니다");
        }
    }

    private static void checkIfNameDuplicates(final String name, final String[] names) {
        int cnt = countDuplicateNames(name, names);
        if (cnt >= 2) {
            throw new IllegalArgumentException("중복되는 이름이 있습니다");
        }
    }

    private static int countDuplicateNames(final String name, final String[] names) {
        int cnt = 0;
        for (String comp : names) {
            if (name.equals(comp)) {
                cnt++;
            }
        }
        return cnt;
    }
}
