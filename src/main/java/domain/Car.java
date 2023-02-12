package domain;

public class Car implements Comparable<Car> {

    public static final int DEFAULT_POSITION_VALUE = 0;
    public static final int MINIMUM_NUMBER_TO_MOVE = 4;

    private final Name name;
    private int position = DEFAULT_POSITION_VALUE;

    public Car(String name) {
        this.name = new Name(name);
    }

    public void move(int number) {
        if (number >= MINIMUM_NUMBER_TO_MOVE) {
            position++;
        }
    }

    public boolean isSamePosition(Car other) {
        return this.position == other.position;
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}
