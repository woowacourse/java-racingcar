package racingcar.model;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
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

    public int move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            position++;
        }
        return position;
    }

    public boolean isMoved() {
        return position > 0;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }
}
