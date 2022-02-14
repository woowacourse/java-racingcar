package racingcar.view;

import static racingcar.view.OutputView.printCarNamesMessage;
import static racingcar.view.OutputView.printNumberMessage;

import racingcar.domain.TrialCount;
import racingcar.utils.Console;

public class InputView {

    private static final int SPLIT_LIMIT = -1;
    private static final String SPLIT_DELIMITER = ",";

    public static String[] insertName() {
        printCarNamesMessage();
        String input = Console.readLine();
        return input.split(SPLIT_DELIMITER, SPLIT_LIMIT);
    }

    public static TrialCount insertNumber() {
        printNumberMessage();
        return new TrialCount(Console.readLine());
    }
}
