package racingcar.domain.car;

import racingcar.domain.GoOrStop;

public class Car implements Comparable<Car> {
    private static final String IS = " : ";

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Car(String name, int location) {
        this.name = new Name(name);
        this.position = new Position(location);
    }

    public void play() {
        if (GoOrStop.decideToGo()) {
            move();
        }
    }

    private void move() {
        position.moveForward();
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
