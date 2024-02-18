package domain.car;

import domain.name.Name;

public class Car {
    private static final Integer FORWARD_POWER_THRESHOLD = 4;

    private final Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
        this.position = 0;
    }

    public Name getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void race(Integer power) {
        if (power >= FORWARD_POWER_THRESHOLD) {
            this.position++;
        }
    }

    public boolean isAtPosition(int position) {
        return this.position == position;
    }
}
