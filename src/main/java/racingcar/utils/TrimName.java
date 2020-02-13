package racingcar.utils;

public class TrimName {

	private static final String BLANK = " ";
	private static final String NO_BLANK = "";

	private TrimName(){}

	public static String removeAllBlankInName(String name) {
		return name.replaceAll(BLANK, NO_BLANK);
	}
}
