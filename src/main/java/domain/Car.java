package domain;

public class Car {
    private static final int MOVED_LOWER_BOUND = 4;
    private static final String INVALID_LENGTH_MESSAGE = "자동차의 이름은 5자 이하여야 합니다.";

    private String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = 0;
    }

    private void validate(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVED_LOWER_BOUND) {
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
