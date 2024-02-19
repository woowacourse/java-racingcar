package util;

import java.util.function.Supplier;

public class ExceptionHandler {

    public static <T> T run(Supplier<T> callback) {
        try {
            return callback.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return run(callback);
        }
    }
}
