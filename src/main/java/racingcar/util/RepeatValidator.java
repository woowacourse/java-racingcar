package racingcar.util;

import racingcar.view.ErrorView;

public class RepeatValidator {

    public static void runUntilValidate(Runnable expression) {
        boolean isSuccess = false;
        while (!isSuccess) {
            isSuccess = tryRunnable(expression);
        }
    }

    private static boolean tryRunnable(Runnable expression) {
        try {
            expression.run();
            return true;
        } catch (RuntimeException exception) {
            ErrorView.printError(exception.getMessage());
            return false;
        }
    }
}
