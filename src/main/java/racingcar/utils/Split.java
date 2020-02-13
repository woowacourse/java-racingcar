package racingcar.utils;

public class Split {

    private static final String COMMA = ",";

    private Split() {
    }

    public static String[] splitInputName(String values) {
        return values.split(Split.COMMA);
    }
}
