package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void moveForward() {
        position++;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }
}
