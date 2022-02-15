package racingcar.util;

import java.util.stream.IntStream;

public class StringUtils {

    public static String[] splitByDelimiter(String string, String delimiter) {
        return string.split(delimiter);
    }

    public static String[] stripStringArray(String[] array) {
        int length = array.length;
        String[] copyArr = new String[length];
        IntStream.range(0, length).forEach(i -> copyArr[i] = array[i].strip());
        return copyArr;
    }

}
