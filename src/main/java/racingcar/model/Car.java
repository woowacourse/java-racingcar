package racingcar.model;

public class Car {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MOVE_LINE = 4;

    private final String name;
    private int position;

    public Car(String name, int position) {
        checkIfNameUnderFive(name);

        this.name = name;
        this.position = position;
    }

    private void checkIfNameUnderFive(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_LINE) {
            position = position + 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
