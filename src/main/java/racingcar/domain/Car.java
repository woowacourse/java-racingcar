package racingcar.domain;

public class Car {
    private final String name;
    private int count;

    private static final int MOVE_CONDITION = 3;
    private static final int STEP = 1;

    public Car(final String name) {
        this.name = name;
        this.count = 0;
    }

    public void move(final int randomNumber) {
        if (randomNumber > MOVE_CONDITION) {
            this.count += STEP;
        }
    }

    public boolean isSameCount(final Car car) {
        return this.count == car.count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
