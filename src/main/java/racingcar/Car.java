package racingcar;

public class Car {
    private static final int CAR_MOVE_CONDITION = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveOrNot(int randomNumber) {
        if (randomNumber >= CAR_MOVE_CONDITION) {
            ++position;
        }
    }
}
