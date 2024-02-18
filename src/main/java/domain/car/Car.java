package domain.car;

import domain.name.Name;

public class Car {
    private static final int INITIAL_POSITION = 0;
    public static final int FORWARD_MAX_NUMBER = 10;
    private static final int FORWARD_THRESHOLD = 4;
    private final Name name;
    private int position;

    public Car(final Name name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public Name getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void race(final int power) {
        if (power >= FORWARD_THRESHOLD) {
            this.position++;
        }
    }

    public boolean comparePosition(final int position) {
        return this.position == position;
    }

}
