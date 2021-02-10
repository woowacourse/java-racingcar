package racingcar.domain;

public class Car implements Comparable<Car> {
    private static final int MOVE_PIVOT = 4;

    private Name name;
    private int position;

    public Car(final Name name) {
        this(name, 0);
    }

    public Car(final Name name, final int position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public int compareTo(final Car anotherCar) {
        return Integer.compare(this.getPosition(), anotherCar.getPosition());
    }

    public void moveForward(int randomNumber) {
        if (isMoveNumber(randomNumber)) {
            this.position++;
        }
    }

    private boolean isMoveNumber(final int number) {
        return MOVE_PIVOT <= number;
    }

    public boolean isMaxPosition(final Car maxPositionCar) {
        return this.position == maxPositionCar.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return this.position;
    }
}
