package racingcar.domain;

public class Car {
    private static final int MOVE_CONDITION = 4;


    private final String name;
    private int position;

    public Car(String name, int position) {
        CarNameValidator.validateCarName(name);
        this.name = name;
        this.position = position;
    }

    public void move(int value) {
        if (value >= MOVE_CONDITION) {
            position++;
        }
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

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
