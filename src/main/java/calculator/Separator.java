package calculator;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {

    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.*)\n(.*)");
    private static final String STANDARD_UNITS = ",:";
    private static final String SEPARATOR_FORMAT = "[%s]";
    private static final String EMPTY_STRING = "";

    public List<String> splitByUnits(final String text) {
        final String unitsForSeparate = extractCustomUnits(text) + STANDARD_UNITS;
        final String regexForSeparate = String.format(SEPARATOR_FORMAT, unitsForSeparate);
        final String targetString = extractString(text);
        return List.of(targetString.split(regexForSeparate));
    }

    private String extractCustomUnits(final String text) {
        final int indexOfUnits = 1;
        return extractIndexByPattern(text, indexOfUnits)
                .orElse(EMPTY_STRING);
    }

    private String extractString(final String text) {
        final int indexOfTargetString = 2;
        return extractIndexByPattern(text, indexOfTargetString)
                .orElse(text);
    }

    private Optional<String> extractIndexByPattern(final String targetValue, final int index) {
        final Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(targetValue);
        if (matcher.find()) {
            return Optional.ofNullable(matcher.group(index));
        }
        return Optional.empty();
    }

}
