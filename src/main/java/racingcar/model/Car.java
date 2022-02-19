package racingcar.model;

import racingcar.model.utils.NumberGenerator;

public class Car implements Comparable<Car> {

    private static final int MOVE_MIN_VALUE = 4;

    private final Name name;
    private final Position position;

    public Car(String carName) {
        this.name = new Name(carName);
        this.position = Position.createStartPosition();
    }

    public void move(NumberGenerator numberGenerator) {
        if (numberGenerator.generate() >= MOVE_MIN_VALUE) {
            this.position.increase();
        }
    }

    public boolean isSamePosition(Car car) {
        return position.equals(car.getPosition());
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return this.name;
    }

    @Override
    public int compareTo(Car o) {
        return this.position.compareTo(o.getPosition());
    }
}
