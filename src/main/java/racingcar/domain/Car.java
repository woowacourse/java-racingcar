package racingcar.domain;

public class Car {

    private static final int CONDITION_FOR_MOVE = 4;
    private static final int DEFAULT_POSITION = 0;

    private final CarName name;
    private int position;

    public Car(String name) {
        this(new CarName(name), DEFAULT_POSITION);
    }

    public Car(CarName name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(int target) {
        if (target >= CONDITION_FOR_MOVE) {
            position++;
        }
    }

    public boolean isSamePosition(int target) {
        return position == target;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

}
