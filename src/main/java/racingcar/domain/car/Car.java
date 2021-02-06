package racingcar.domain.car;

public class Car {
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void moveByRandomNumber(int number) {
        if (number >= MINIMUM_NUMBER_TO_MOVE) {
            position.moveForward();
        }
    }

    public String getName() {
        return name.getName();
    }

    public String getPosition() {
        return position.getPosition();
    }
}
