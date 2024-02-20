package domain;

public class Car {
    private static final int MOVE_BOUND_NUMBER = 4;
    private final Name name;
    private int position;

    public Car(final Name name, final int position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(final String name) {
        return new Car(new Name(name), 0);
    }

    public void move(final int power) {
        if (power >= MOVE_BOUND_NUMBER) {
            position++;
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}
