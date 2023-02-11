package domain;

public class Car {

    private static final String NO_NAME_EXISTS_MESSAGE = "[ERROR] 자동차의 이름은 반드시 있어야 합니다.";
    private static final String INVALID_LENGTH_MESSAGE = "[ERROR] 자동차의 이름은 5글자까지 가능합니다.";
    private static final int MOVED_LOWER_BOUND = 4;

    private final String name;
    private int position;

    public Car(final String name) throws IllegalArgumentException {
        validate(name);
        this.name = name;
        this.position = 0;
    }

    public Car(final String name, final int position) throws IllegalArgumentException {
        validate(name);
        this.name = name;
        this.position = position;
    }

    private void validate(final String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(NO_NAME_EXISTS_MESSAGE);
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        }
    }

    public void move(final int number) {
        if (number >= MOVED_LOWER_BOUND) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
