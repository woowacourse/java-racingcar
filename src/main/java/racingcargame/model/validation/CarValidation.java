package racingcargame.model.validation;

public class CarValidation {

    private static final int MAX_NAME_LENGTH = 5;

    public static void checkBlank(String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
