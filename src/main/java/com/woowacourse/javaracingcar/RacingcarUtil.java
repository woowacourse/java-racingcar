package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.Car;
import com.woowacourse.javaracingcar.domain.CarDto;

import java.util.*;
import java.util.stream.Collectors;

public class RacingcarUtil {
    private static final int MAX_NAME_LENGTH = 5;

    private RacingcarUtil() {
    }

    public static List<Car> createCars(final List<String> carNames) {
        final List<Car> cars = new ArrayList<>();
        for (String s : carNames) {
            cars.add(new Car(s));
        }

        return cars;
    }

    public static String joinCarNames(final List<CarDto> cars) {
        return cars.stream()
            .map(CarDto::getName)
            .collect(Collectors.joining(", "));
    }

    public static List<String> splitIntoNames(final String input) {
        final String[] names = input.split(",");
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
        }
        return Arrays.asList(names);
    }

    public static boolean isValidNameInput(final List<String> carNames) {
        final List<String> validNameList = filterInvalidNames(carNames);
        return validNameList.size() == carNames.size();
    }

    private static List<String> filterInvalidNames(final List<String> names) {
        return new HashSet<>(names).stream()
            .filter(RacingcarUtil::checkNameLength)
            .filter(RacingcarUtil::checkIfNameIsEmpty)
            .filter(RacingcarUtil::checkIfNameIncludesSpace)
            .collect(Collectors.toList());
    }

    private static boolean checkNameLength(final String name) {
        return name.length() <= MAX_NAME_LENGTH;
    }

    private static boolean checkIfNameIsEmpty(final String name) {
        return !name.isEmpty();
    }

    private static boolean checkIfNameIncludesSpace(final String name) {
        return !name.contains(" ");
    }
}
