package utils;

public class Log {

    private static final String ERROR_PREFIX = "[ERROR] ";
    public static void error(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
