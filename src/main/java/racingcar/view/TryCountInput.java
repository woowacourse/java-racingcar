package racingcar.view;

import java.util.Scanner;
import racingcar.domain.validator.TryCountValidator;

public class TryCountInput {

    private Scanner scanner;
    private TryCountValidator tryCountValidator;
    private View view;

    public TryCountInput() {
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
