package racing.domain;

public class Car implements Comparable<Car> {

    private static final int MOVE_CONDITION = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void move(int number) {
        if (number >= MOVE_CONDITION) {
            addPosition();
        }
    }

    private void addPosition() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isSamePosition(Car other) {
        return this.position == other.position;
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }
}
