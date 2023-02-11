package racingcar.common.log;

public class Logger {

    private static final String ERROR_FORMAT = "\n[ERROR] %s\n";

    public static void error(final String message) {
        System.out.printf((ERROR_FORMAT), message);
    }
}
