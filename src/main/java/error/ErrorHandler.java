package error;

import java.util.function.Supplier;

public class ErrorHandler {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public <T> T executeErrorOccurable(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }
}
