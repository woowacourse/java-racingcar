package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public static final String CUSTOM_REGEX = "//(.)\n(.*)";
	public static final String OR_STRING = "|";
	public static final int MATCH_GROUP_INDEX = 1;
	public static final int MATCH_GROUP_NEXT_INDEX = 2;
	private String regex = "[,:]";

	public String[] splitString(String str) {
		if (str == null || str.isEmpty()) {
			return new String[] {"0"};
		}
		CheckException.checkSplitOk(str, regex);
		Matcher matcher = Pattern.compile(CUSTOM_REGEX).matcher(str);
		if (matcher.find()) {
			regex += OR_STRING + matcher.group(MATCH_GROUP_INDEX);
			CheckException.checkSplitOk(str, regex);
			return matcher.group(MATCH_GROUP_NEXT_INDEX).split(regex);
		}
		return str.split(regex);
	}

	public int sumString(String[] splitStringArray) {
		CheckException.check(splitStringArray);
		return Arrays.stream(splitStringArray).mapToInt(Integer::parseInt).sum();
	}
}