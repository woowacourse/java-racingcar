package domain;

public class Car {

    private static final int MOVED_LOWER_BOUND = 4;

    private final Name name;
    private int position;

    public Car(final String name, final int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public Car(final String name) {
        this(name, 0);
    }

    public void move(final int number) {
        if (number >= MOVED_LOWER_BOUND) {
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
