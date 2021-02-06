package racingcar.utils;

public class ErrorUtils {

    private static final String FORMAT = "\n[ERROR] %s\n";

    public static void printError(Exception e) {
        System.out.printf((FORMAT) + "%n", e.getMessage());
    }
}
