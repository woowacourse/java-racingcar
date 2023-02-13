package racingcar.domain;

public class Car {
    public static final int MIN_TRY_COUNT = 0;
    public static final int RANDOM_NUMBER_BOUNDARY = 10;
    public static final int FORWARD_BOUNDARY = 4;

    private final Name name;
    private final Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void movePosition() {
        this.position.increasePosition();
    }

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }
}
