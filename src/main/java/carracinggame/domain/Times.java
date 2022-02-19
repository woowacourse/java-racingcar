package carracinggame.domain;

public class Times {
    public static void isRightTimes(String input) throws IllegalArgumentException {
        final String REGEX = "^[0-9]+$";
        if (!input.matches(REGEX)) {
            throw new IllegalArgumentException();
        }
    }
}
