package domain;

public class Car {

    private static final int NAME_LOWER_BOUND = 0;
    private static final int NAME_UPPER_BOUND = 5;
    private static final int MOVE_LOWER_BOUND = 4;
    private static final String INVALID_NAME_LENGTH_MESSAGE = "차의 이름은 1자 이상 ~ 5자 이하여야 합니다.";

    private String name;
    private int position = 0;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (NAME_LOWER_BOUND == name.length() || NAME_UPPER_BOUND < name.length()) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
        }
    }

    public void move(final int value) {
        if (value >= MOVE_LOWER_BOUND) {
            position++;
        }
    }

    public boolean isSamePosition(Car car) {
        return car.position == this.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
