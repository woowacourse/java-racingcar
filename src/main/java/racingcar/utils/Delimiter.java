package racingcar.utils;

import java.util.List;

public enum Delimiter {

    COMMA(","),
    COLON(":"),
    SPACE(" "),
    BAR("-");

    private final String unit;

    Delimiter(final String unit) {
        this.unit = unit;
    }

    public static String[] splitWithComma(final String targetString) {
        return targetString.split(COMMA.unit);
    }

    public static String appendSpaceBehind(final String targetString) {
        return targetString + SPACE.unit;
    }

    public static String joinWithComma(final List<String> strings) {
        return String.join(COMMA.unit + SPACE.unit, strings);
    }

    public static String concatWithColon(final String preString, final String postString) {
        final String separator = SPACE.unit + COLON.unit + SPACE.unit;
        return preString + separator + postString;
    }

    public static String repeatUnderBar(final int count) {
        return BAR.unit.repeat(count);
    }

}
