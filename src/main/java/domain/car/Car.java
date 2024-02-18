package domain.car;

import domain.name.Name;

public class Car {
    private static final int INITIAL_POSITION = 0;
    public static final int FORWARD_MAX_NUMBER = 10;
    private static final int FORWARD_THRESHOLD = 4;
    private final Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public Name getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void race(Integer number) {
        if (number >= FORWARD_THRESHOLD) {
            this.position++;
        }
    }

    public boolean comparePosition(int position) {
        if (this.position == position) {
            return true;
        }
        return false;
    }

}
