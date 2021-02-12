package racingcar.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final int NO_CARS_IN_GAME = 0;
    private static final int NO_DUPLICATE = 0;
    private static final int ZERO = 0;

    private InputView() {
    }

    public static String[] getUserCarInput(final Scanner scanner) {
        OutputView.readCarName();
        final String userInput = scanner.nextLine();
        try {
            final String[] carNames = userInput.split(",");
            return validateCarNames(carNames);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getUserCarInput(scanner);
        }
    }

    private static String[] validateCarNames(final String[] carNames) {
        validateCarNamesEmpty(carNames);
        validateCarNamesDuplicate(carNames);
        return carNames;
    }

    private static void validateCarNamesEmpty(final String[] carNames) {
        if (carNames.length == NO_CARS_IN_GAME) {
            throw new IllegalArgumentException("[Error] 최소 하나의 자동차 이름을 입력하세요.\n");
        }
    }

    private static void validateCarNamesDuplicate(final String[] carNames) {
        List<String> checkDuplicate = Arrays.asList(carNames);
        int duplicate = checkDuplicate.stream()
                .filter(i -> Collections.frequency(checkDuplicate, i) > 1)
                .collect(Collectors.toSet()).size();

        if (duplicate != NO_DUPLICATE) {
            throw new IllegalArgumentException("[Error] 자동차 이름이 중복됩니다.\n");
        }
    }


    public static int getUserTrialNumberInput(final Scanner scanner) {
        OutputView.readTrialNumber();
        final String userInput = scanner.nextLine();
        try {
            return validatePositive(Integer.parseInt(userInput));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage("[Error] 횟수는 자연수여야 합니다.\n");
            return getUserTrialNumberInput(scanner);
        }
    }

    private static int validatePositive(final int userInput) {
        if (userInput < ZERO) {
            throw new IllegalArgumentException();
        }
        return userInput;
    }
}
