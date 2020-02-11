package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Split {
	public static String[] splitByCommaOrColon(String value) {
		return value.split("[,:]");
	}

	public static String getCustomDelimiter(String value) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(value);
		if (m.find()) {
			return m.group(1);
		}
		throw new NullPointerException("구분자 기호를 입력하세요");
	}
}
