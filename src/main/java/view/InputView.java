package view;

import exception.ErrorMessage;
import exception.RacingCarGameException;

import static view.ViewMessages.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> enterCarNames() {
        System.out.println(CAR_NAMES_REQUEST_MESSAGE);
        String rawCarNames = scanner.nextLine();
        return validateCarNames(rawCarNames);
    }

    private static List<String> validateCarNames(String rawCarNames){
        validateBlankInput(rawCarNames);
        List<String> carNames = split(rawCarNames);
        return carNames.stream().map(name -> name.trim()).toList();
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
        System.out.println();
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
