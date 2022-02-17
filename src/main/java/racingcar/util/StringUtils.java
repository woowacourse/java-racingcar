package racingcar.util;

public class StringUtils {
    public static String[] splitByDelimiter(String string, String delimiter) {
        return string.split(delimiter);
    }

    public static String[] stripStringArray(String[] array) {
        int length = array.length;
        String[] copyArr = new String[length];
        for (int i = 0; i < length; i++) {
            copyArr[i] = array[i].strip();
        }
        return copyArr;
    }
}
