package view;

import java.util.Optional;
import java.util.function.Supplier;

public class ExceptionRetryHandler {
    private static final String ERROR_PREFIX = "[ERROR] ";

    private ExceptionRetryHandler() {}

    public static <R> R handle(Supplier<R> supplier) {
        Optional<R> result = Optional.empty();
        while (result.isEmpty()) {
            result = retry(supplier);
        }

        return result.get();
    }

    private static <R> Optional<R> retry(Supplier<R> supplier) {
        try {
            return Optional.of(supplier.get());
        } catch (IllegalArgumentException exception) {
            System.out.println(ERROR_PREFIX + exception.getMessage());
            return Optional.empty();
        }
    }
}
