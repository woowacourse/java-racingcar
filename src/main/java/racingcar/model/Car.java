package racingcar.model;

public class Car implements Comparable<Car> {

    private String name;
    private int position;

    private static final int MIN_MOVING_NUM = 4;

    public Car(String name, int startPosition) {
        this.name = name;
        this.position = startPosition;
    }

    public boolean canMoving(int power) {
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
