package racingcar.view.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class InputUtils {
    private static final String DELIMITER = ",";

    private InputUtils() {
    }

    public static List<String> splitByComma(String input) {
        if (input == null) {
            return List.of();
        }
        return Arrays.stream(input.split(DELIMITER, -1)).toList();
    }

    public static <T> T retryOnException(Supplier<T> supplier) {
        while(true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
