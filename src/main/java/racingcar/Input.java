package racingcar;


import static racingcar.Output.*;
import static racingcar.Validator.*;

public class Input {

    private static final int SPLIT_LIMIT = -1;

    private static String SPLIT_DELIMITER = ",";

    public static String[] insertRightName() {
        printCarNamesMessage();
        String input = Console.readLine();
        validateBlank(input);
        String[] names = input.split(SPLIT_DELIMITER, SPLIT_LIMIT);
        validateEachCarName(names);
        return names;
    }

    public static int insertRightNumber() {
        printNumberMessage();
        String input = Console.readLine();
        return toInt(input);
    }
}
