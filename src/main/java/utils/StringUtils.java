package utils;

public class StringUtils {
    private StringUtils() {
    }

    public static boolean isBlank(String str) {
        if (str == null) {
            return true;
        }
        return "".equals(str.trim());
    }
}
