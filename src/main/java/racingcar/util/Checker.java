package racingcar.util;

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

}
