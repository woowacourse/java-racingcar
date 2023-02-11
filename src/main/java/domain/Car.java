package domain;

public class Car {

    private static final int MOVED_LOWER_BOUND = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int number) {
        if (number >= MOVED_LOWER_BOUND) {
            position++;
        }
    }

    public boolean hasSamePosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
