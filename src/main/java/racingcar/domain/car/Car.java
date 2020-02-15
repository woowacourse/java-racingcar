package racingcar.domain.car;

public class Car implements Comparable<Car> {
    private static final int NUMBER_POSSIBLE_TO_GO = 4;
    private static final String IS = " : ";

    private final Name name;
    private Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void moveByNumber(int number) {
        if (canMove(number)) {
            move();
        }
    }

    private boolean canMove(int number) {
        if (number >= NUMBER_POSSIBLE_TO_GO) {
            return true;
        }
        return false;
    }

    private void move() {
        position.moveForward();
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getRoundResult() {
        StringBuilder result = new StringBuilder();
        result.append(name);
        result.append(IS);
        result.append(position);
        return result.toString();
    }

    public boolean isAtSameLocation(Car anotherCar) {
        return this.position.compareTo(anotherCar.position) == 0;
    }

    @Override
    public int compareTo(Car anotherCar) {
        if (this.position.compareTo(anotherCar.position) > 0) {
            return 1;
        }

        if (this.position.compareTo(anotherCar.position) < 0) {
            return -1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
