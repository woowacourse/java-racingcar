package racingcar.view;

import java.util.Scanner;
import racingcar.domain.validator.TryCountInputValidator;

public class TryCountInput {

    private Scanner scanner;
    private TryCountInputValidator tryCountInputValidator;
    private View view;

    public TryCountInput() {
        this.scanner = new Scanner(System.in);
        this.tryCountInputValidator = new TryCountInputValidator();
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
            tryCountInputValidator.validate(tryCount);
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
