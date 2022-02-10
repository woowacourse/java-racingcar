package racingcar;

import java.util.Scanner;

import static racingcar.Validator.*;

public class Input {

    private static String SPLIT_DELIMITER = ",";

    public static String[] insertRightName() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        validateBlank(input);
        String[] names = input.split(SPLIT_DELIMITER);
        validateEachCarName(names);
        return names;
    }
}
