package error;

import java.util.function.Supplier;

public class ErrorHandler {

    public static final String ERROR_PREFIX = "[ERROR] ";

    public static void handle(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }
}
