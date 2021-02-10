package racingcar.domain;

public class Car {
    private static final int DEFAULT_MOVABLE_VALUE = 4;

    private final Name name;
    private Position position;
    private MoveCondition moveCondition;

    public Car(String name) {
        this(name, number -> number > DEFAULT_MOVABLE_VALUE);
    }

    public Car(String name, MoveCondition moveCondition) {
        this.name = new Name(name);
        this.position = Position.ZERO;
        this.moveCondition = moveCondition;
    }

    public void move(int number) {
        if (moveCondition.isMovable(number)) {
            position = position.nextPosition();
        }
    }

    public void changeMovableCondition(MoveCondition moveCondition) {
        this.moveCondition = moveCondition;
    }

    public boolean isSamePosition(Position thatPosition) {
        return this.position.equals(thatPosition);
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }


}
