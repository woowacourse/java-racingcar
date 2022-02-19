package util;

public class StringUtil {

    public static String[] split(String input, String regex) {
        return input.split(regex, -1);
    }
}
