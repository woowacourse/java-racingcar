package racingcar.model;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int INITIAL_POSITION = 0;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return this.name + " : " + "-".repeat(this.position);
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            position++;
        }
    }
}
