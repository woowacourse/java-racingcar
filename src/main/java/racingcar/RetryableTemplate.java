package racingcar;

import java.util.function.Consumer;

public class RetryableTemplate {

    private RetryableTemplate() {

    }

    public static void execute(Runnable runnable, Consumer<Exception> exceptionHandler) {
        try {
            runnable.run();
            return;
        } catch (Exception e) {
            exceptionHandler.accept(e);
        }
        execute(runnable, exceptionHandler);
    }
}
