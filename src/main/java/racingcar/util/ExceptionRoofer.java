package racingcar.util;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ExceptionRoofer {

    public static <T> T generate(Supplier<T> supplier,  Consumer<String> consumer) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                consumer.accept(exception.getMessage());
            }
        }
    }
}
