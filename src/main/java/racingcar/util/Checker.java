package racingcar.util;

public class Checker {

	private void isNull(String str) throws IllegalArgumentException {
		if (str == null) {
			throw new IllegalArgumentException(StringConst.ERROR_NULL.getValue());
		}
	}

}
