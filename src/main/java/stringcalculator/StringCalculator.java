package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	private static final String CUSTOM_REGEX = "//(.)\n(.*)";
	private static final String OR_STRING = "|";
	private static final int MATCH_GROUP_INDEX = 1;
	private static final int MATCH_GROUP_NEXT_INDEX = 2;
	private String regex = "[,:]";

	public int calculateString(String string) {
		return sumString(splitString(string));
	}

	public String[] splitString(String string) {
		if (string == null || string.isEmpty()) {
			return new String[] {"0"};
		}
		CheckException.checkSplitOk(string, regex);
		Matcher matcher = Pattern.compile(CUSTOM_REGEX).matcher(string);
		if (matcher.find()) {
			regex += OR_STRING + matcher.group(MATCH_GROUP_INDEX);
			CheckException.checkSplitOk(string, regex);
			return matcher.group(MATCH_GROUP_NEXT_INDEX).split(regex);
		}
		return string.split(regex);
	}

	public int sumString(String[] splitStringArray) {
		CheckException.check(splitStringArray);
		return Arrays.stream(splitStringArray).mapToInt(Integer::parseInt).sum();
	}
}