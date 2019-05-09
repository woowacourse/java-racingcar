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

    public static boolean isValidNameInput(List<String> nameList) {
        List<String> validNameList = filterInvalidNames(nameList);
        return validNameList.size() == nameList.size();
    }

    public static List<Car> createCars(List<String> carNameList) {
        List<Car> cars = new ArrayList<>();
        for (String s : carNameList) {
            cars.add(new Car(s));
        }

        return cars;
    }

    private static List<String> filterInvalidNames(List<String> nameList) {
        return nameList.stream()
            .filter(RacingcarUtil::checkIfNameIsEmpty)
            .filter(RacingcarUtil::checkIfNameIncludesSpace)
            .filter(RacingcarUtil::checkNameLength)
            .filter(n -> checkIfNameDuplicates(n, nameList))
            .collect(Collectors.toList());
    }

    private static boolean checkNameLength(String name) {
        return name.length() <= MAX_NAME_LENGTH;
    }

    private static boolean checkIfNameIncludesSpace(String name) {
        return !name.contains(" ");
    }

    private static boolean checkIfNameIsEmpty(String name) {
        return !name.isEmpty();
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
