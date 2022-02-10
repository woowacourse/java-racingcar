package racingcar;

public class Parser {
    private static final int EMPTY = 0;
    private static final int MAX_NAME_LENGTH = 5;

    public static String[] split(String text) {
        String[] carNames = text.split(",");
        if (carNames.length == EMPTY) {
            throw new IllegalArgumentException();
        }

        for (String carName : carNames) {
            isValidCarNames(carName);
        }
        return carNames;
    }

    private static void isValidCarNames(String carName) {
        if (carName == null || carName.isEmpty() || carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
