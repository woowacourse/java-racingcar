package racingcar.domain;

import racingcar.domain.car.Name;
import racingcar.domain.car.Position;

public class Car {
    private static final String CAR_STATUS_DELIMITER = " : ";
    private static final String CAR_POSITION_STATUS = "-";

    private final Name name;
    private Position position;
    private CarMoveRule rule;

    public Car(String name) {
        this.name = new Name(name);
        this.position = Position.ZERO;
        this.rule = new CarMoveRule();
    }

    public Name getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public void moveByDefaultRule() {
        move(rule.applyDefaultRule());
    }

    public void move(boolean moveRule) {
        if (moveRule) {
            this.position = position.move();
        }
    }

    public String toString() {
        return this.name + CAR_STATUS_DELIMITER + repeat(CAR_POSITION_STATUS, this.position.getPosition());
    }

    private String repeat(String str, int num) {
        return new String(new char[num]).replace("\0", str);
    }

    public int aboveMaxPosition(int maxPosition) {
        if (this.position.getPosition() > maxPosition) {
            return this.position.getPosition();
        }
        return maxPosition;
    }

    public boolean isMaxPosition(int maxPosition) {
        if (maxPosition == this.position.getPosition()) {
            return true;
        }
        return false;
    }
}
