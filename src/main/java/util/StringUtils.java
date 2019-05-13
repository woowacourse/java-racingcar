package util;

public class StringUtils {
    public static boolean isLengthInRange(String string, int min, int max) {
        return (min <= string.length())
                && (string.length() <= max);
    }

    public static boolean isNumberString(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}