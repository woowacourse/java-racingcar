package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Split {
	public static String[] splitByCommaOrColon(String value) {
		return value.split("[,:]");
	}

	public static String[] splitNumberByCustomByDelimiter(String value) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(value);
		if (m.find()) {
			String delimiter = m.group(1);
			return m.group(2).split(delimiter);
		}
		throw new NullPointerException("유효하지 않은 구분자와 피연산자 입니다.");
	}
}
