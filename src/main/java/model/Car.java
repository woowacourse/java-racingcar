package model;

public class Car {

    private static final int MOVE_POWER_LIMIT = 4;
    private static final int DEFAULT_POSITION = 1;
    private static final int MOVE_UNIT = 1;

    private final Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    public void move(final int power) {
        if (power >= MOVE_POWER_LIMIT) {
            this.position += MOVE_UNIT;
        }
    }

    public int getCurrentPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }

}
