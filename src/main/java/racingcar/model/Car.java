package racingcar.model;

public class Car {
    public static final int MINIMUM_POSITION = 0;
    public static final int MOVE_FORWARD = 4;
    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(name, MINIMUM_POSITION);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int number) {
        if (canMove(number)) {
            this.position++;
        }
    }

    public boolean canMove(int number) {
        return number >= MOVE_FORWARD;
    }
}
