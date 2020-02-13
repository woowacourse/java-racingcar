package racingcar.domain;

public class Car {
    public static final int MAXIMUM_NAME = 5;

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    protected Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void moveForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean hasOverFiveCharacterName() {
        return name.length() > MAXIMUM_NAME;
    }

    public boolean isEmpty() {
        return name.isEmpty();
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }
}
