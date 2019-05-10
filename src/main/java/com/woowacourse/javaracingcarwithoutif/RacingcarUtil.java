package com.woowacourse.javaracingcarwithoutif;

import com.woowacourse.javaracingcarwithoutif.domain.Car;
import com.woowacourse.javaracingcarwithoutif.domain.CarDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingcarUtil {
    private static final int MAX_NAME_LENGTH = 5;

    private RacingcarUtil() {}

    public static String joinCarNames(List<CarDto> cars) {
        return cars.stream()
            .map(CarDto::getName)
            .collect(Collectors.joining(", "));
    }

    public static List<String> splitIntoNames(String input) {
        String[] names = input.split(",");
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
        }
        return Arrays.asList(names);
    }

    public static boolean isValidNameInput(List<String> carNames) {
        List<String> validNameList = filterInvalidNames(carNames);
        return validNameList.size() == carNames.size();
    }

    public static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String s : carNames) {
            cars.add(new Car(s));
        }

        return cars;
    }

    private static List<String> filterInvalidNames(List<String> names) {
        return names.stream()
            .filter(RacingcarUtil::checkNameLength)
            .filter(RacingcarUtil::checkIfNameIsEmpty)
            .filter(RacingcarUtil::checkIfNameIncludesSpace)
            .filter(n -> checkIfNameDuplicates(n, names))
            .collect(Collectors.toList());
    }

    private static boolean checkNameLength(String name) {
        return name.length() <= MAX_NAME_LENGTH;
    }

    private static boolean checkIfNameIsEmpty(String name) {
        return !name.isEmpty();
    }

    private static boolean checkIfNameIncludesSpace(String name) {
        return !name.contains(" ");
    }

    private static boolean checkIfNameDuplicates(String name, List<String> names) {
        return countDuplicateNames(name, names) < 2;
    }

    private static int countDuplicateNames(String name, List<String> names) {
        return (int)names.stream()
            .filter(n -> name.equals(n))
            .count();
    }
}
