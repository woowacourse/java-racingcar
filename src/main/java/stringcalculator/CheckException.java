package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckException extends Throwable {

	private static final String NULL_ERROR_MESSAGE = "빈 문자열이 포함되어 있습니다!";
	private static final String NUMBER_ERROR_MESSAGE = "숫자가 아닌 파라미터가 포함되어 있습니다!";
	private static final String SPLIT_FRONT_ERROR_MESSAGE = "구분자가 맨 앞 위치에 있습니다!";
	private static final String SPLIT_BACK_ERROR_MESSAGE = "구분자가 맨 뒤 위치에 있습니다!";
	private static final String SPLIT_MID_ERROR_MESSAGE = "구분자가 올바르지 않은 위치에 있습니다!";
	private static final String FRONT_REGEX = "(.)[";
	private static final String BACK_REGEX = "]{2,}(.)*";
	private static final int FRONT_STRING_INDEX = 0;

	public static void check(String[] array) {
		Arrays.stream(array).forEach(s -> {
			checkNull(s);
			checkNumber(s);
		});
	}

	public static void checkNumber(String string) {
		try {
			Integer.parseInt(string);
		} catch (Exception e) {
			throw new RuntimeException(NUMBER_ERROR_MESSAGE);
		}
	}

	public static void checkNull(String string) {
		if (string == null || string.isEmpty()) {
			throw new RuntimeException(NULL_ERROR_MESSAGE);
		}
	}

	public static void checkSplitOk(String string, String regex) {
		checkFrontString(string, regex);
		checkBackString(string, regex);
		checkMidString(string, regex);
	}

	private static void checkMidString(String string, String regex) {
		Matcher mMid = Pattern.compile(FRONT_REGEX + regex + BACK_REGEX).matcher(string);
		if (mMid.matches()) {
			throw new RuntimeException(SPLIT_MID_ERROR_MESSAGE);
		}
	}

	private static void checkBackString(String string, String regex) {
		if (regex.contains(Character.toString(string.charAt(string.length() - 1)))) {
			throw new RuntimeException(SPLIT_BACK_ERROR_MESSAGE);
		}
	}

	private static void checkFrontString(String string, String regex) {
		if (regex.contains(Character.toString(string.charAt(FRONT_STRING_INDEX)))) {
			throw new RuntimeException(SPLIT_FRONT_ERROR_MESSAGE);
		}
	}

}
