package racingcar.utils;

import java.util.List;

public enum Delimiter {

    COMMA(","),
    COLON(":"),
    SPACE(" "),
    BAR("-");

    private final String unit;

    Delimiter(String unit) {
        this.unit = unit;
    }

    public static String[] splitWithComma(String targetString) {
        return targetString.split(COMMA.unit);
    }

    public static String appendSpaceBehind(String targetString) {
        return targetString + SPACE.unit;
    }

    public static String joinWithComma(List<String> strings) {
        return String.join(COMMA.unit + SPACE.unit, strings);
    }

    public static String concatWithColon(String preString, String postString) {
        String separator = SPACE.unit + COLON.unit + SPACE.unit;
        return preString + separator + postString;
    }

    public static String repeatUnderBar(int count) {
        return BAR.unit.repeat(count);
    }

}
