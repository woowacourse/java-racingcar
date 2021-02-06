package racingcar.utils;

import racingcar.domain.TryCount;
import java.util.Arrays;
import java.util.Scanner;

public class InputUtils {

    private static final String nameSeparator = ",";

    public static String[] getNames(Scanner scanner) {
        String names = scanner.next();
        String[] nameStrings = splitNames(names);
        InputValidator.checkValidNames(nameStrings);
        InputValidator.isDuplicatedNames(nameStrings);
        return nameStrings;
    }

    public static int getTryCount(Scanner scanner) {
        String tryCount = scanner.next();
        return InputValidator.isValidTryCount(tryCount);
    }

    public static String[] splitNames(String line) {
        return Arrays.stream(line.split(nameSeparator))
            .map(String::trim)
            .toArray(String[]::new);
    }
}
