package calculator.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Split {
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    public static String[] splitByCommaOrColon(String value) {
        return value.split("[,:]");
    }

    public static String[] splitNumberByCustomByDelimiter(String value) {
        Matcher m = PATTERN.matcher(value);
        if (m.find()) {
            String delimiter = m.group(1);
            return m.group(2).split(delimiter);
        }
        throw new IllegalArgumentException("유효하지 않은 구분자와 피연산자 입니다.");
    }
}
