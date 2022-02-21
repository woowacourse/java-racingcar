package racingcar.models;

public class Car {

    private static final int FORWARD_STANDARD = 4;
    private static final int INITIAL_POSITION = 0;

    private final String name;
    private int position;

    public Car(final String name) {
        this.name = name;
        position = INITIAL_POSITION;
    }

    public void goForward(int number) {
        if (number >= FORWARD_STANDARD) {
            position++;
        }
    }

    public boolean isSamePosition(final int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Car name= " + name + ", position=" + position;
    }
}
