package racingcar.utils;

public class ErrorUtils {

    private static final String FORMAT = System.lineSeparator() + "[ERROR] %s" + System.lineSeparator();

    private ErrorUtils(){
    }

    public static void printError(Exception e) {
        System.out.printf((FORMAT) + "%n", e.getMessage());
    }
}
