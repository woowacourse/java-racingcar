package domain.car;

import domain.name.Name;

public class Car {
    private static final int INITIAL_POSITION = 0;
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

    public void race(final MovableStrategy engine) {
        if (engine.isMove()) {
            this.position++;
        }
    }

    public boolean comparePosition(final int position) {
        return this.position == position;
    }

}
