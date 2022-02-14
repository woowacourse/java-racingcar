package racingcar.domain;

public class Car {

    private static final int START_POSITION = 0;

    private final String name;
    private int position;

    private Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public void forwardCarPosition() {
        position++;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
