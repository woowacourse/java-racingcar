package stringCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckException extends Throwable {

	static final String NULL_ERROR_MESSAGE = "빈 문자열이 포함되어 있습니다!";
	static final String NUMBER_ERROR_MESSAGE = "숫자가 아닌 파라미터가 포함되어 있습니다!";
	static final String NUMBER_RANGE_ERROR_MESSAGE = "숫자 범위에 일치하지 않습니다!";
	static final String SplitOk_FITST_ERROR_MESSAGE = "구분자가 맨앞 위치에 있습니다!";
	static final String SplitOk_LAST_ERROR_MESSAGE = "구분자가 맨뒤 위치에 있습니다!";
	static final String SplitOk_mid_ERROR_MESSAGE = "구분자가 연속된 위치에 있습니다!";


	public static void check(String[] array) {
		for (String s : array) {
			checkNull(s);
			checkNumber(s);
			checkNumberRange(s);
		}
	}

	public static void checkNumber(String string) {
		try {
			Integer.parseInt(string);
		} catch (Exception e) {
			throw new RuntimeException(NUMBER_ERROR_MESSAGE);
		}
	}

	public static void checkNumberRange(String string) {
		if (Integer.parseInt(string) < 0) {
			throw new RuntimeException(NUMBER_RANGE_ERROR_MESSAGE);
		}
	}

	public static void checkNull(String string) {
		if (string == null || string.isEmpty()) {
			throw new RuntimeException(NULL_ERROR_MESSAGE);
		}
	}

	public static void checkSplitOk(String string, String regex) {
		if (regex.contains(Character.toString(string.charAt(0)))){
			throw new RuntimeException(SplitOk_FITST_ERROR_MESSAGE);
		}
		if (regex.contains(Character.toString(string.charAt(string.length() - 1)))) {
			throw new RuntimeException(SplitOk_LAST_ERROR_MESSAGE);
		}
		Matcher mMid= Pattern.compile("(.)[" + regex + "]{2,}(.)*").matcher(string);
		if (mMid.matches()) {
			throw new RuntimeException(SplitOk_mid_ERROR_MESSAGE);
		}

	}


}
