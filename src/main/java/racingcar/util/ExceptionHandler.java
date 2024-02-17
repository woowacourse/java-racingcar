package racingcar.util;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ExceptionHandler {

    private ExceptionHandler() {
    }

    // Supplier 실행 시 예외가 발생 하면 Consumer 실행 후 반복
    public static <T> T retry(final Supplier<T> supplier, final Consumer<String> consumer) {
        try {
            return supplier.get();
        } catch (final IllegalArgumentException exception) {
            consumer.accept(exception.getMessage());
            return retry(supplier, consumer);
        }
    }
}
