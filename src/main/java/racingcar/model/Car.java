package racingcar.model;

public class Car implements Comparable<Car> {

    private static final int MOVE_FORWARD_CONDITION = 4;

    private final String name;
    private int position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public void moveForward(final int number) {
        if (isMoveForward(number)) {
            position++;
        }
    }

    private boolean isMoveForward(final int number) {
        return number >= MOVE_FORWARD_CONDITION;
    }

    public String getCarName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(car.getPosition(), this.position);
    }
}
