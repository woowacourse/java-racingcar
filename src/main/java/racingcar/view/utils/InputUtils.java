package racingcar.view.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public class InputUtils {
    private static final String DELIMITER = ",";

    private InputUtils() {
    }

    public static int parseToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(ErrorMessage.INPUT_NOT_A_NUMBER);
        }
    }

    public static List<String> splitByComma(final String input) {
        if (input == null) {
            return List.of();
        }
        return Arrays.stream(input.split(DELIMITER, -1)).map(String::trim).toList();
    }

    public static <T> T retryOnException(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
