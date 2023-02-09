package domain;

public class Car {

    private static final int MOVE_LOWER_BOUND = 4;

    private Name name;
    private int position = 0;

    public Car(String name) {
        this.name = new Name(name);
    }

    public void move(final int value) {
        if (value >= MOVE_LOWER_BOUND) {
            position++;
        }
    }

    public boolean isSamePosition(Car car) {
        return car.position == this.position;
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }
}
