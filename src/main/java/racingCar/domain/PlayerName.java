package racingCar.domain;

public class PlayerName {
    private final String name;

    public PlayerName(String name) throws IllegalArgumentException {
        checkNameLength(name);
        this.name = name;
    }

    private void checkNameLength(String name) throws IllegalArgumentException {
        if (lengthOutOfRange(name)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean lengthOutOfRange(String name) {
        return name.isEmpty() || name.length() >= 6;
    }

    public String toString() {
        return this.name;
    }
}
