package domain;

public class Car {

    private static final int MOVED_LOWER_BOUND = 4;

    private final Name name;
    private final Position position;

    private Car(final String name, final int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public static Car from(final String name) {
        return new Car(name, 0);
    }

    public static Car of(final String name, final int position) {
        return new Car(name, position);
    }

    public void move(final int number) {
        if (number >= MOVED_LOWER_BOUND) {
            position.increase();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
