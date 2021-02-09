package racingcar.domain.car;

public class Car {

    public static final int MOVE_CONDITION = 4;
    public static final char SINGLE_VISUAL_POSITION = '-';

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        position = Position.ZERO;
    }

    public String getName() {
        return name.getLiteral();
    }

    public int getPosition() {
        return position.getValue();
    }

    public void move(int integer) {
        if (integer >= MOVE_CONDITION) {
            position.move();
        }
    }

    public boolean isPosition(int position) {
        return this.position.is(position);
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}
