package view;

import java.util.function.Supplier;

public class RetryOnException {
    public static <T> T retryInputOnIllegalArgumentException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return retryInputOnIllegalArgumentException(supplier);
        }
    }
}
