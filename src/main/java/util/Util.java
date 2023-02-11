package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public static final String COMMA_REGEX = ",";

    public static String removeSpace(String input) {
        return input.replaceAll(Regex.SPACE.regex, Regex.NO_SPACE.regex);
    }

    public static List<String> split(String input) {
        return Arrays.stream(input.split(COMMA_REGEX))
                .collect(Collectors.toList());
    }

    private enum Regex {
        SPACE(" "), NO_SPACE("");
        private final String regex;

        Regex(String regex) {
            this.regex = regex;
        }
    }

    private Util() {
    }
}