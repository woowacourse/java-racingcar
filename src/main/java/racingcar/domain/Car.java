package racingcar.domain;

import racingcar.vo.Name;

public class Car implements Comparable<Car>{
    private static final int INIT_POSITION = 0;
    private static final int BOUNDARY = 4;

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(INIT_POSITION);
    }

    public void move(int power) {
        if (power >= BOUNDARY) {
            position.increase();
        }
    }

    public boolean isSamePosition(Car other) {
        return other.position == this.position;
    }

    @Override
    public int compareTo(Car other) {
        return this.position.getPosition() - other.position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

}
