package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {

    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.*)\n(.*)");
    private static final String STANDARD_UNITS = ",:";
    private static final String SEPARATOR_FORMAT = "[%s]";
    private static final String emptyString = "";

    public List<String> splitByUnits(final String text) {
        String unitsForSeparate = extractCustomUnits(text) + STANDARD_UNITS;
        String regexForSeparate = String.format(SEPARATOR_FORMAT, unitsForSeparate);
        String targetString = extractString(text);
        return Arrays.asList(targetString.split(regexForSeparate));
    }

    private String extractCustomUnits(String text) {
        int indexOfUnits = 1;
        return extractIndexByPattern(text, indexOfUnits)
                .orElse(emptyString);
    }

    private String extractString(String text) {
        int indexOfTargetString = 2;
        return extractIndexByPattern(text, indexOfTargetString)
                .orElse(text);
    }

    private Optional<String> extractIndexByPattern(String targetValue, int index) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(targetValue);
        if (matcher.find()) {
            return Optional.ofNullable(matcher.group(index));
        }
        return Optional.empty();
    }

}
