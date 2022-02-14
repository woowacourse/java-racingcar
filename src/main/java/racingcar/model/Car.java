package racingcar.model;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private static final int MOVE_FORWARD_CONDITION = 4;

    private final String name;
    private int position;

    public Car(final String name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public String getCarName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_FORWARD_CONDITION) {
            position++;
        }
    }
}
