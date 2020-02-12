package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;

    private final Name name;
    private Location location;

    Car(String name) {
        validateEmptyName(name);
        validateNameLength(name);

        this.name = new Name(name);
        this.location = new Location();
    }

    public static void validateEmptyName(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNameLength(String input) {
        if (isOverLength(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isOverLength(String input) {
        return input.length() > MAX_NAME_LENGTH;
    }
}
