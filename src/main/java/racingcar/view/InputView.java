package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String REQUEST_CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ERROR_CAR_NAME_LENGTH = "자동차의 이름이 5자 이하여야 합니다.";
    private static final String ERROR_CAR_NAME_BLANK = "자동차의 이름 입력은 공백일 수 없습니다.";
    private static final String REQUEST_ROUND_VALUE = "시도할 회수는 몇회인가요?";
    private static final String ERROR_ROUND_NOT_NUMBER = "입력한 이동 숫자가 숫자의 형태가 아닙니다.";
    private static final String ERROR_ROUND_MINIMUM_ONE = "입력한 이동 숫자가 0 이하일수는 없습니다.";
    private static final String ERROR_CARS_NAME_DUPLICATED = "자동차의 이름에 중복이 있습니다.";
    private static final String ERROR_CAR_NAME_EMPTY = "자동차의 이름 입력은 비어있을 수 없습니다.";
    private static final String ERROR = "[ERROR] ";
    private static final String SPLIT_CARS_NAME = ",";
    private static final String BLANK = " ";
    private static final int SPLIT_LIMIT = -1;
    private static final int CAR_NAME_LIMIT = 5;
    private static final int ROUND_MINIMUM_ONE = 1;

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
        validateCarsNameDuplicated(carsName);
        for (String carName : carsName) {
            validateCarsNameLength(carName);
            validateCarsNameBlank(carName);
            validateCarsNameEmpty(carName);
        }
    }

    private static void validateCarsNameDuplicated(List<String> carsName) {
        if (validateCarsNameSize(carsName)) {
            throw new IllegalArgumentException(ERROR_CARS_NAME_DUPLICATED);
        }
    }

    private static boolean validateCarsNameSize(List<String> carsName) {
        return carsName.stream().distinct().count() != carsName.size();
    }

    private static void validateCarsNameLength(String carName) {
        if (carName.length() > CAR_NAME_LIMIT) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_LENGTH);
        }
    }

    private static void validateCarsNameBlank(String carName) {
        if (carName.contains(BLANK)) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_BLANK);
        }
    }

    private static void validateCarsNameEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_EMPTY);
        }
    }

    public static int getRound() {
        System.out.println(REQUEST_ROUND_VALUE);
        try {
            String inputRound = getInput();
            validateRound(inputRound);
            return Integer.parseInt(inputRound);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return getRound();
        }
    }

    private static void validateRound(String inputRound) {
        validateRoundNumber(inputRound);
        validateRoundMinimumOne(inputRound);
    }

    private static void validateRoundNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_ROUND_NOT_NUMBER);
        }
    }

    private static void validateRoundMinimumOne(String inputRound) {
        if (Integer.parseInt(inputRound) < ROUND_MINIMUM_ONE) {
            throw new IllegalArgumentException(ERROR_ROUND_MINIMUM_ONE);
        }
    }

    private static void printErrorMessage(Exception e) {
        System.out.println(ERROR + e.getMessage());
    }
}
