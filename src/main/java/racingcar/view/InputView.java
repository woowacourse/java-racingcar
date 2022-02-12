package racingcar.view;


import static racingcar.utils.Validator.toInt;
import static racingcar.utils.Validator.validateBlank;
import static racingcar.utils.Validator.validateEachCarName;
import static racingcar.view.OutputView.printCarNamesMessage;
import static racingcar.view.OutputView.printNumberMessage;

import racingcar.utils.Console;

public class InputView {

    private static final int SPLIT_LIMIT = -1;

    private static final String SPLIT_DELIMITER = ",";

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
