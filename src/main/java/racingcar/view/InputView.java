package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.trynumber.TryNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String PLEASE_INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String PLEASE_INPUT_TRY_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String ERROR_ONLY_INPUT_NUMBER_MESSAGE = "[ERROR] 숫자가 아닌 값은 입력할 수 없습니다.";
    private static final String ERROR_NOT_INPUT_EMPTY_VALUE_MESSAGE = "[ERROR] 빈 값은 입력할 수 없습니다.";
    private static final String ERROR_NOT_INPUT_NULL_VALUE_MESSAGE = "[ERROR] 시도회수는 null이 될 수 없습니다.";

    private InputView() {
    }

    public static Cars inputCarNames(Scanner scanner) {
        System.out.println(PLEASE_INPUT_CAR_NAMES_MESSAGE);
        String input = scanner.nextLine();
        try {
            return new Cars(wrapCarNamesToCars(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCarNames(scanner);
        }
    }

    private static List<Car> wrapCarNamesToCars(String input) {
        return Arrays.stream(input.split(CAR_NAME_DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public static TryNumber inputTryNumber(Scanner scanner) {
        String input = inputTryNumberValue(scanner);
        try {
            validateTryNumber(input);
            return new TryNumber(Integer.parseInt(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputTryNumber(scanner);
        }
    }

    private static String inputTryNumberValue(Scanner scanner) {
        System.out.println(PLEASE_INPUT_TRY_NUMBER_MESSAGE);
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    private static void validateTryNumber(String input) {
        validateNullValue(input);
        validateEmptyValue(input);
        validateNumberTypes(input);
    }

    private static void validateNullValue(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ERROR_NOT_INPUT_NULL_VALUE_MESSAGE);
        }
    }

    private static void validateEmptyValue(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_NOT_INPUT_EMPTY_VALUE_MESSAGE);
        }
    }

    private static void validateNumberTypes(String input) {
        for (char partOfTryNumber : input.toCharArray()) {
            validateNumberType(partOfTryNumber);
        }
    }

    private static void validateNumberType(char partOfTryNumber) {
        if (Character.isDigit(partOfTryNumber)) {
            return;
        }

        throw new IllegalArgumentException(ERROR_ONLY_INPUT_NUMBER_MESSAGE);
    }
}
