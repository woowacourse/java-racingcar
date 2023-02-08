package racingcar;

public class Car {
    private static final int START_POSITION = -1;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public void move() {
        position++;
    }
}
