package racingcar.utils;

public class Split {

    public static final String DELIMITER = ",";

    private Split() {
    }

    public static String[] splitInputName(String values) {
        return values.split(DELIMITER);
    }
}
