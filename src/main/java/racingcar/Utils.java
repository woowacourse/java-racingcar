package racingcar;

public class Utils {
    public static final String STRING_REGEX = ",";

    public static String[] splitAndTrim(String names) {
        String[] carNames = names.split(STRING_REGEX);
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
        return carNames;
    }
}
