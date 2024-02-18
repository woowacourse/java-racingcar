package racingcar.model;

public class Car {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        checkIfNameUnderFive(name);

        this.name = name;
        this.position = 0;
    }

    private void checkIfNameUnderFive(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
