package domain;

public class Car implements Comparable<Car> {

    public static final int MINIMUM_NUMBER_TO_MOVE = 4;

    private final Name name;
    private final Position position;

    public Car(Name name) {
        this.name = name;
        this.position = new Position();
    }

    public void move(int number) {
        if (number >= MINIMUM_NUMBER_TO_MOVE) {
            position.increase();
        }
    }

    public boolean isSamePosition(Car other) {
        return this.position.equals(other.position);
    }

    @Override
    public int compareTo(Car other) {
        return position.compareTo(other.position);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
