package view;

import java.util.function.Supplier;

public class ExceptionRetryHandler {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final int RETRY_LIMIT_COUNT = 100;

    private ExceptionRetryHandler() {
    }

    public static <R> R retryUntilValid(final Supplier<R> supplier, final int retryCount) {
        if (retryCount == RETRY_LIMIT_COUNT) {
            String errorMessage = String.format("재입력 제한 횟수 %d를 초과하여 프로그램을 종료합니다.", RETRY_LIMIT_COUNT);
            throw new IllegalStateException(errorMessage);
        }
        try {
            return supplier.get();
        } catch (IllegalArgumentException exception) {
            System.out.println(ERROR_PREFIX + exception.getMessage());
            return retryUntilValid(supplier, retryCount + 1);
        }
    }
}
