package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String REQUEST_CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ERROR_CAR_NAME_LENGTH = "자동차의 이름이 5자 이하여야 합니다.";
    private static final String ERROR_CAR_NAME_BLANK = "자동차의 입력은 빈칸일 수 없습니다.";
    private static final String ERROR = "[ERROR] ";
    private static final String SPLIT_CARS_NAME = ",";
    private static final int SPLIT_LIMIT = -1;
    private static final int CAR_NAME_LIMIT = 5;

    private static final Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        return scanner.nextLine();
    }

    public static List<String> getCarsName() {
        System.out.println(REQUEST_CARS_NAME);
        try {
            List<String> carsName = convertCarsName(getInput());
            validateCarsName(carsName);
            return carsName;
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return getCarsName();
        }
    }

    private static List<String> convertCarsName(String name) {
        return Arrays.stream(name.split(SPLIT_CARS_NAME, SPLIT_LIMIT))
            .collect(Collectors.toList());
    }

    private static void validateCarsName(List<String> carsName) {
        for (String carName : carsName) {
            validateCarsNameLength(carName);
            validateCarsNameBlank(carName);
        }
    }

    private static void validateCarsNameBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_BLANK);
        }
    }

    private static void validateCarsNameLength(String carName) {
        if (carName.length() > CAR_NAME_LIMIT) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_LENGTH);
        }
    }

    private static void printErrorMessage(Exception e) {
        System.out.println(ERROR + e.getMessage());
    }
}
