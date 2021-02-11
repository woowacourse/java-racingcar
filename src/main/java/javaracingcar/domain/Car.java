package javaracingcar.domain;

public class Car {
    private static final int MIN_CAN_MOVE_NUMBER = 4;

    private final Name name;
    private int position;

    public Car(String name) {
        this(new Name(name), 0);
    }

    public Car(String name, int position) {
        this(new Name(name), position);
    }

    public Car(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name.toString();
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (number >= MIN_CAN_MOVE_NUMBER) {
            position++;
        }
    }

    public boolean isAtPosition(int position) {
        return this.position == position;
    }
}
