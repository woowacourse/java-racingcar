package racingcar;

public class Utils {
    public static String[] splitAndTrim(String names) {
        String[] carNames = names.split(",");
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
        return carNames;
    }
}
