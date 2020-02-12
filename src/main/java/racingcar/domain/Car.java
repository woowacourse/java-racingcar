package racingcar.domain;

public class Car {
    public static void validateName(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
