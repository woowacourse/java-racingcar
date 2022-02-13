package racingcar.util;

public class CarNameValidator {
    private static final int EMPTY = 0;
    private static final int MAX_NAME_LENGTH = 5;

    public static void validate(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkQuantity(String[] carNames) {
        if (carNames.length == EMPTY) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkCarName(String carName) {
        if (carName == null || carName.isEmpty() || carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
