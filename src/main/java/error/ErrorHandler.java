package error;

import java.util.function.Supplier;

public class ErrorHandler {

    public static final String ERROR_PREFIX = "[ERROR] ";

    // TODO: 예외 발생 시 재입력받는 부분에 사용
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
