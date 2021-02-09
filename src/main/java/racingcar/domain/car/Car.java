package racingcar.domain.car;

public class Car {

    public static final int MOVE_CONDITION = 4;

    private final Name name;
    private Position position;

    private Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public Car(final String name) {
        this(new Name(name), Position.ZERO);
    }

    public String getName() {
        return name.getLiteral();
    }

    public int getPosition() {
        return position.getValue();
    }

    public void move(int conditionNumber) {
        if (conditionNumber >= MOVE_CONDITION) {
            position = position.move();
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
