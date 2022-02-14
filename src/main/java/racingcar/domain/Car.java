package racingcar.domain;

public class Car {

    private static final int START_POSITION = 0;
    private static final int FORWARD_BOUNDARY_NUMBER = 4;

    private final String name;
    private int position;

    private Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public static Car createByName(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= FORWARD_BOUNDARY_NUMBER) {
            position++;
        }
    }
}
