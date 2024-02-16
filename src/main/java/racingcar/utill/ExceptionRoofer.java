package racingcar.utill;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ExceptionRoofer {

    public static <T> T retry(final Supplier<T> supplier, final Consumer<String> consumer) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException exception) {
            consumer.accept(exception.getMessage());
            return retry(supplier, consumer);
        }
    }
}
