package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;

public class Checker {

	private void isNull(String str) throws IllegalArgumentException {
		if (str == null) {
			throw new IllegalArgumentException(StringConst.ERROR_NULL.getValue());
		}
	}

	private void isBlank(String str) throws IllegalArgumentException {
		if (str.equals("")) {
			throw new IllegalArgumentException(StringConst.ERROR_BLANK.getValue());
		}
	}

	private void isOverSize(String[] str) throws IllegalArgumentException {
		int overSizeCount = (int)Arrays.stream(str)
			.filter(eachStr -> eachStr.length() > IntegerConst.SIZE_BOUND.getValue())
			.count();
		if (overSizeCount > IntegerConst.ZERO.getValue()) {
			throw new IllegalArgumentException(StringConst.ERROR_SIZE.getValue());
		}
	}

	private void isZeroCars(String[] str) throws IllegalArgumentException {
		if (str.length == IntegerConst.ZERO.getValue()) {
			throw new IllegalArgumentException(StringConst.ERROR_NO_CAR.getValue());
		}
	}

	private void isSpecialChar(String[] str) throws IllegalArgumentException {
		int specialCount = (int)Arrays.stream(str)
			.filter(eachStr -> !eachStr.matches("^[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]+$"))
			.count();
		if (specialCount > IntegerConst.ZERO.getValue()) {
			throw new IllegalArgumentException(StringConst.ERROR_SPECIAL_CHAR.getValue());
		}
	}

	private void isDuplicate(String[] str) throws IllegalArgumentException {
		HashSet<String> set = new HashSet<String>(Arrays.asList(str));
		if (set.size() != str.length) {
			throw new IllegalArgumentException(StringConst.ERROR_DUPLICATE.getValue());
		}
	}

	public String checkNameConditions(String str) {
		try {
			isNull(str);
			isBlank(str);
			String[] commaSeperatedName = str.split(StringConst.DELIMITER.getValue());
			isDuplicate(commaSeperatedName);
			isZeroCars(commaSeperatedName);
			isSpecialChar(commaSeperatedName);
			isOverSize(commaSeperatedName);
			return str;
		} catch (IllegalArgumentException error) {
			return error.getMessage();
		}
	}

}
