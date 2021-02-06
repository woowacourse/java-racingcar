package racingcar.utils;

import java.util.Arrays;
import java.util.Scanner;
import racingcar.validator.InputValidator;

public class InputUtils {

    private static final String nameSeparator = ",";

    public static String[] getNames(Scanner scanner) {
        String names = scanner.nextLine();
        return splitNames(names);
    }

    public static int getInteger(Scanner scanner){
        String next = scanner.next();
        InputValidator.isOnlyNumber(next);
        return Integer.parseInt(next);
    }

    public static String[] splitNames(String line) {
        return Arrays.stream(line.split(nameSeparator))
            .map(String::trim)
            .toArray(String[]::new);
    }
}
