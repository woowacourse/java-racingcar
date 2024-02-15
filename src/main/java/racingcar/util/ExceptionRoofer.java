package racingcar.util;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ExceptionRoofer {

    public static <T> T generate(final Supplier<T> supplier, final Consumer<String> consumer) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException exception) {
            consumer.accept(exception.getMessage());
            return generate(supplier, consumer);
        }
    }
}
