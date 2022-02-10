package racingcar;

import java.util.Scanner;

import static racingcar.Output.*;
import static racingcar.Validator.*;

public class Input {

    private static Scanner scanner = new Scanner(System.in);
    private static String SPLIT_DELIMITER = ",";

    public static String[] insertRightName() {
        printCarNamesMessage();
        String input = scanner.nextLine();
        validateBlank(input);
        String[] names = input.split(SPLIT_DELIMITER, -1);
        validateEachCarName(names);
        return names;
    }

    public static int insertRightNumber() {
        printNumberMessage();
        String input = scanner.nextLine();
        return toInt(input);
    }
}
