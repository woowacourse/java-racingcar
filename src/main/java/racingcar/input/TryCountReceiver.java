package racingcar.input;

import java.util.Scanner;
import racingcar.input.validator.TryCountValidator;
import racingcar.view.View;

public class TryCountReceiver {

    private Scanner scanner;
    private TryCountValidator tryCountValidator;
    private View view;
    private String receivedTryCount;

    public TryCountReceiver() {
        this.scanner = new Scanner(System.in);
        this.tryCountValidator = new TryCountValidator();
        this.view = new View();
        this.receivedTryCount = null;
    }

    public int receive() {
        while (!checkRules()) {
        }
        return parseTryCount(receivedTryCount);
    }

    private boolean checkRules() {
        try {
            view.printInputTryCountMessage();
            receivedTryCount = tryCountValidator.validate(scanner.nextLine());
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
