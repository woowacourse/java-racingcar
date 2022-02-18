package racingcar.input;

import java.util.Scanner;
import racingcar.input.validator.TryCountValidator;
import racingcar.view.View;

public class TryCountReceiver {

    private Scanner scanner;
    private TryCountValidator tryCountValidator;
    private View view;

    public TryCountReceiver() {
        this.scanner = new Scanner(System.in);
        this.tryCountValidator = new TryCountValidator();
        this.view = View.getInstance();
    }

    public int receive() {
        boolean retrySwitch = true;
        String tryCount = null;
        while (retrySwitch) {
            view.printInputTryCountMessage();
            tryCount = scanner.nextLine();
            retrySwitch = !checkRules(tryCount);
        }
        return parseTryCount(tryCount);
    }

    private boolean checkRules(String tryCount) {
        try {
            tryCountValidator.validate(tryCount);
            return true;
        } catch (IllegalArgumentException exception) {
            view.printExceptionMessage(exception);
            return false;
        }
    }

    private int parseTryCount(String input) {
        return Integer.parseInt(input);
    }
}
