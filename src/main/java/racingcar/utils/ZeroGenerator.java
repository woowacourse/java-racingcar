package racingcar.utils;

public class ZeroGenerator implements NumberGenerator {

	private static final int ZERO = 0;

	@Override
	public int getNumber() {
		return ZERO;
	}
}
