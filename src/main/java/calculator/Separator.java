package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {

	private static final List<String> STANDARD_UNITS = new ArrayList<>(Arrays.asList(",", ":"));
	private static final String SEPARATOR_DELIMITER = "|";
	private static final String CUSTOM_FORMAT_REGEX = "//(.*)\n(.*)";

	public List<String> splitByUnits(String targetValue) {
		List<String> customUnits = extractCustomUnits(targetValue);
		customUnits.addAll(STANDARD_UNITS);

		targetValue = extractOriginalString(targetValue);

		String separatorRegex = String.join(SEPARATOR_DELIMITER, customUnits);
		return Arrays.asList(targetValue.split(separatorRegex));
	}

	private List<String> extractCustomUnits(String targetValue) {
		Matcher matcher = Pattern.compile(CUSTOM_FORMAT_REGEX).matcher(targetValue);
		if (matcher.find()) {
			return new ArrayList<>(Arrays.asList(matcher.group(1).split("")));
		}
		return new ArrayList<>();
	}

	private String extractOriginalString(String targetValue) {
		Matcher matcher = Pattern.compile(CUSTOM_FORMAT_REGEX).matcher(targetValue);
		if (matcher.find()) {
			targetValue = matcher.group(2);
		}
		return targetValue;
	}

}
