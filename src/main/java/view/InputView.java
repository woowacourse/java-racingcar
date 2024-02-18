package view;

import exception.ErrorMessage;
import exception.RacingCarGameException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static view.ViewMessages.*;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> enterCarNames() {
        System.out.println(CAR_NAMES_REQUEST_MESSAGE);
        String rawCarNames = scanner.nextLine();
        return validateCarNames(rawCarNames);
    }

    private static List<String> validateCarNames(String rawCarNames) {
        validateBlankInput(rawCarNames);
        List<String> carNames = split(rawCarNames);
        return carNames.stream().map(String::trim).toList();
    }

    private static List<String> split(String rawCarNames) {
        return Arrays.stream(rawCarNames.split(CAR_NAMES_SPLIT_SYMBOL))
                .toList();
    }

    private static void validateBlankInput(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw RacingCarGameException.from(ErrorMessage.BLANK_INPUT_ERROR);
        }
    }

    public static int enterCount() {
        System.out.println(COUNT_REQUEST_MESSAGE);
        String rawCount = scanner.nextLine();
        return validateCount(rawCount);
    }

    private static int validateCount(String rawCount) {
        try {
            return Integer.parseInt(rawCount);
        } catch (NumberFormatException exception) {
            throw RacingCarGameException.from(ErrorMessage.INVALID_COUNT_ERROR);
        }
    }
}
