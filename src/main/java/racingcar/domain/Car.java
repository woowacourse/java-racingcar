package racingcar.domain;

public class Car {
    private static final int INITIAL_POSITION = 0;
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;

    private final Name name;
    private int position = INITIAL_POSITION;

    public Car(String name) {
        this.name = new Name(name);
    }

    public void move(int number) {
        if (number >= MINIMUM_NUMBER_TO_MOVE) {
            position++;
        }
    }

    public boolean isPositionEqualTo(int position) {
        return this.position == position;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}
