package racingcar.view.input;

import java.util.Scanner;
import racingcar.validator.TryCountSettingValidator;
import racingcar.view.View;

public class TryCountInput {

    private Scanner scanner;
    private TryCountSettingValidator tryCountSettingValidator;
    private View view;

    public TryCountInput() {
        this.scanner = new Scanner(System.in);
        this.tryCountSettingValidator = new TryCountSettingValidator();
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
            tryCountSettingValidator.validate(tryCount);
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
