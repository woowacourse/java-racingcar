package racingcar.domain.car;

public class Car {

    private static final int START_POSITION = 0;

    private final Name name;
    private Position position;

    public Car(final String name) {
        this(name, START_POSITION);
    }

    public Car(final String name, final int position) {
        this.name = new Name(name);
        this.position = Position.valueOf(position);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void move(final int randomNumber) {
        position = position.addPosition(randomNumber);
    }

    public boolean isEqualPosition(final int value) {
        return position.isEqualNumber(value);
    }
}