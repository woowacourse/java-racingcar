package racingcar.domain;

public class Car {
    private static final int INITIAL_POSITION = 0;
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;

    private final Name name;
    private int position = INITIAL_POSITION;

    public Car(String name) {
        this.name = new racingcar.domain.Name(name);
    }

    public void move(int randomNumber) {
        if (isMovable(randomNumber)) {
            position++;
        }
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber >= MINIMUM_NUMBER_TO_MOVE;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}
