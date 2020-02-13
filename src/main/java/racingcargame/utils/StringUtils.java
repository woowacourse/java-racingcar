package racingcargame.utils;

public class StringUtils {

    public static String multiply(String baseString, int count) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append(baseString);
        }

        return sb.toString();
    }
}
