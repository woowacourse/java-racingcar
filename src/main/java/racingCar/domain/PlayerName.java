package racingCar.domain;

public class PlayerName {
    private final String name;

    public PlayerName(final String name) {
        checkIsValidLength(name);
        this.name = name;
    }

    private void checkIsValidLength(String name) throws IllegalArgumentException {
        if (isGreaterThanFive(name) || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isGreaterThanFive(String name) {
        return name.length() > 5;
    }

}
