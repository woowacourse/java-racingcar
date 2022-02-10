package racingcar;

import java.util.Scanner;

import static racingcar.Validator.*;

public class Input {

    private static Scanner scanner = new Scanner(System.in);
    private static String SPLIT_DELIMITER = ",";

    public static String[] insertRightName() {
        String input = scanner.next();
        validateBlank(input);
        String[] names = input.split(SPLIT_DELIMITER);
        validateEachCarName(names);
        return names;
    }

    public static int insertRightNumber() {
        String input = scanner.next();
        return toInt(input);
    }
}
