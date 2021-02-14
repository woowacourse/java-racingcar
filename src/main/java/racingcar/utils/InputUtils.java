package racingcar.utils;

import java.util.Arrays;
import java.util.Scanner;

public class InputUtils {

    private static final String NAME_SEPARATOR = ",";

    public static String[] inputToNames(Scanner scanner) {
        String names = scanner.nextLine();
        return splitNames(names);
    }

    public static int inputToInteger(Scanner scanner) {
        String next = scanner.next();
        isOnlyNumber(next);
        return Integer.parseInt(next);
    }

    public static String[] splitNames(String line) {
        return Arrays.stream(line.split(NAME_SEPARATOR))
            .map(String::trim)
            .toArray(String[]::new);
    }

    public static void isOnlyNumber(String round) {
        for (char c : round.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Round must be integer");
            }
        }
    }
}
