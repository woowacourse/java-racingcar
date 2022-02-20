package racingcar.view;

import static racingcar.view.OutputView.printCarNamesMessage;
import static racingcar.view.OutputView.printNumberMessage;

import racingcar.utils.Console;

public class InputView {

    public static String insertName() {
        printCarNamesMessage();
        return Console.readLine();
    }

    public static String insertNumber() {
        printNumberMessage();
        return Console.readLine();
    }
}
