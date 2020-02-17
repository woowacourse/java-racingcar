package racinggame.domain;

public class Car {
    private static final int FORWARD_NUMBER = 4;
    private static final int START_POSITION = 0;
    private final String name;
    private int position;

    public Car(String name) {
        this(name, START_POSITION);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public boolean move(int random) {
        if (random >= FORWARD_NUMBER) {
            position++;
            return true;
        }
        return false;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getMaxPosition(int maxPosition) {
        return Math.max(position, maxPosition);
    }
}
