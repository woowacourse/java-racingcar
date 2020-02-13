package racingcar.utils;

public class TrimName {
    private TrimName() {
    }

    public static String removeAllBlankInName(String name) {
        return name.replaceAll(" ", "");
    }
}
