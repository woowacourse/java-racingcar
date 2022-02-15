package racingcar.utils;

public class IntegerUtils {

    public static int parseInt(String text, IllegalArgumentException exception) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw exception;
        }
    }
}
