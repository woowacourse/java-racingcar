package view;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ExceptionRetryHandler {
    private static final String ERROR_PREFIX = "[ERROR] ";

    private ExceptionRetryHandler() {}

    public static <R> R retryUntilValid(Supplier<R> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                System.out.println(ERROR_PREFIX + exception.getMessage());
            }
        }
    }
}