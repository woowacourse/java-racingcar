package racingcar.model;

public class Car {

    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final int MINIMUM_STEP_FORWARD_STANDARD = 4;
    private static final int DEFAULT_POSITION = 0;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    public int move(int randomNumber) {
        if (randomNumber >= MINIMUM_STEP_FORWARD_STANDARD) {
            position++;
        }
        return position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {
        if (isNameEmpty(name) || name.length() > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNameEmpty(String name) {
        return name == null || name.isEmpty();
    }
}
