package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValueEditor {

    public static String removeSpace(String input) {
        return input.replaceAll(Regex.SPACE.regex, Regex.NO_SPACE.regex);
    }

    public static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }

    private enum Regex {
        SPACE(" "), NO_SPACE("");
        private final String regex;

        Regex(String regex) {
            this.regex = regex;
        }
    }

    private ValueEditor() {
    }
}