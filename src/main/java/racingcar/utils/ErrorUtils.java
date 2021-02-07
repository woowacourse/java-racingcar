package racingcar.utils;

public class ErrorUtils {

    private static final String FORMAT = "\n[ERROR] %s\n";

    private ErrorUtils() {
        throw new IllegalStateException("ErrorUtils is an utility class");
    }

    public static void printError(Exception e) {
        System.out.printf((FORMAT) + "%n", e.getMessage());
    }
}
