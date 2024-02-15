package racingcar.exception;

import java.util.function.Supplier;

public class ExceptionHandler {

    private static final String ERROR = "[ERROR] ";

    public <T> T run(Supplier<T> callback) {
        while (true) {
            try {
                return callback.get();
            } catch (IllegalArgumentException exception) {
                System.out.printf("%n%s%s%n%n", ERROR, exception.getMessage());
            }
        }
    }
}
