package racingcar.domain;

public class Car {
    private static final int INITIAL_POSITION = 0;
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;

    private final CarName name;
    private int position = INITIAL_POSITION;

    public Car(final String name) {
        this.name = new CarName(name);
    }

    public void move(final int randomNumber) {
        if (isMovable(randomNumber)) {
            position++;
        }
    }

    private boolean isMovable(final int randomNumber) {
        return randomNumber >= MINIMUM_NUMBER_TO_MOVE;
    }

    public boolean isPositionEqualTo(final int position) {
        return this.position == position;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}
