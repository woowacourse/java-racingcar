package racingcar.util;

import java.util.function.Consumer;

public class RetryableTemplate {

    public void execute(Runnable runnable, Consumer<Exception> exceptionHandler) {
        try {
            runnable.run();
            return;
        } catch (Exception e) {
            exceptionHandler.accept(e);
        }
        execute(runnable, exceptionHandler);
    }
}
