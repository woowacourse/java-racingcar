package racingcar.domain;

public class Car {
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(int number) {
        if (number >= MINIMUM_NUMBER_TO_MOVE) {
            position.increase();
        }
    }

    public boolean isPositionEqualTo(int position) {
        return this.position.isMatchPosition(position);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
