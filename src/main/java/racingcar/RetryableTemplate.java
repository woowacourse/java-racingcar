package racingcar;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class RetryableTemplate {

    private RetryableTemplate() {

    }

    public static <T> T execute(Supplier<T> supplier, Consumer<Exception> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            exceptionHandler.accept(e);
        }
        return execute(supplier, exceptionHandler);
    }
}
