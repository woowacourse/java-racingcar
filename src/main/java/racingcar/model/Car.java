package racingcar.model;

public class Car {
    private static final int MOVE_CONDITION = 4;

    private int position;
    private String name;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(int number) {
        if (number >= MOVE_CONDITION) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }
}
