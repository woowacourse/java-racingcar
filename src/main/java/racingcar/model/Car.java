package racingcar.model;

public class Car {

    private static final int MOVE_FORWARD_CONDITION = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward(int randomNumber) {
        if (randomNumber >= MOVE_FORWARD_CONDITION) {
            position++;
        }
    }

    public String getCarName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
