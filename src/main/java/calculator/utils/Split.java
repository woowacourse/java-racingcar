package calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Split {

    private static final int DELIMITER_GROUP = 1;
    private static final int NUMBER_GROUP = 2;

    public static String[] splitByCommaOrColon(String value) {
        return value.split("[,:]");
    }

    public static String[] splitNumberByCustomByDelimiter(String value) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(value);
        if (m.find()) {
            String delimiter = m.group(DELIMITER_GROUP);
            return m.group(NUMBER_GROUP).split(delimiter);
        }
        throw new IllegalArgumentException("유효하지 않은 구분자와 피연산자 입니다.");
    }
}
