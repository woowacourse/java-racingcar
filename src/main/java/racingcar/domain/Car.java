package racingcar.domain;

public class Car {
    private static final int GO_FORWARD_CONDITION = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void goForward(int num) {
        if (num >= GO_FORWARD_CONDITION) {
            position += 1;
        }
    }

    public boolean checkIfPositionSame(int position) {
        return this.position == position;
    }
}
