package racingcar.entity;

import static racingcar.util.RandomUtil.checkMoveOrWait;

public class Car implements Comparable<Car> {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void progress() {
        if (checkMoveOrWait()) {
            position++;
        }
    }

    @Override
    public int compareTo(Car other) {
        return other.getPosition() - this.position;
    }
}
