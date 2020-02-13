package racingcar.utils;

public class TrimName {

    public static final String BLANK = " ";
    public static final String REPLACEMENT = "";

    private TrimName() {
    }

    public static String removeAllBlankInName(String name) {
        return name.replaceAll(BLANK, REPLACEMENT);
    }
}
