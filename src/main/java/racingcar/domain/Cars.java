package racingcar.domain;

public class Cars {
    public static void validateNames(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
