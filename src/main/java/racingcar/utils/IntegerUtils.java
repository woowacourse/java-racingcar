package racingcar.utils;

public class IntegerUtils {

    public static int parseInt(String round, IllegalArgumentException exception) {
        try {
            return Integer.parseInt(round);
        } catch (NumberFormatException e) {
            throw exception;
        }
    }
}
