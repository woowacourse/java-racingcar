package carracinggame.util;

public class StringUtils {

    private static final String CAR_NAMES_SEPARATOR = ",";

    public static String[] splitCarNames(String input) {
        return input.split(CAR_NAMES_SEPARATOR);
    }

    public static String[] trimCarNames(String[] carNames) {
        for (int idx = 0; idx < carNames.length; idx++) {
            carNames[idx] = carNames[idx].trim();
        }
        return carNames;
    }
}
