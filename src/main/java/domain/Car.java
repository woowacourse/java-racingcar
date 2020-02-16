package domain;

import java.util.Objects;

public class Car {
    private static final int MIN_MOVABLE_NUM = 4;
    private static final int INITIAL_POSITION = 0;
    private final Name name;
    private int position;

    public Car(String name) {
        this(name, INITIAL_POSITION);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public boolean move(int randomNumber) {
        if (randomNumber >= MIN_MOVABLE_NUM) {
            position++;
            return true;
        }
        return false;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }
}
