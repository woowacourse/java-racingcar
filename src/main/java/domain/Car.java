package domain;

public class Car {

    private static final int MOVED_LOWER_BOUND = 4;
    private static final String NO_NAME_EXISTS_MESSAGE = "[ERROR] 자동차의 이름은 반드시 있어야 합니다.";
    private static final String INVALID_LENGTH_MESSAGE = "[ERROR] 자동차의 이름은 5글자까지 가능합니다.";

    private String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = 0;
    }

    private void validate(String name) {
        int length = name.length();

        if (length == 0) {
            throw new IllegalArgumentException(NO_NAME_EXISTS_MESSAGE);
        }

        if (length > 5) {
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
