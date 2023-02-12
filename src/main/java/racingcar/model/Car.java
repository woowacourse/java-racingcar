package racingcar.model;

public class Car implements Comparable<Car> {

    private static final int MIN_MOVING_NUM = 4;

    private final String name;
    private int position;

    public Car(final String name, int startPosition) {
        this.name = name;
        this.position = startPosition;
    }

    public boolean canMoving(final int power) {
        return power >= MIN_MOVING_NUM;
    }

    public void move(boolean isMoving) {
        if (isMoving) {
            this.position++;
        }
    }

    public boolean isSamePositionCar(Car maxPositionCar) {
        return this.position == maxPositionCar.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car anotherCar) {
        return this.position - anotherCar.position;
    }
}
