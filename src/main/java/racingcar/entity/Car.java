package racingcar.entity;

import static racingcar.util.RandomUtil.checkMoveOrWait;

public class Car implements Comparable<Car> {

    public static final int INITIAL_VALUE = 0;

    private final String name;
    private int position = INITIAL_VALUE;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void progress(){
        if(checkMoveOrWait()) {
            position++;
        }
    }

    @Override
    public int compareTo(Car other) {
        return other.getPosition() - this.position;
    }
}
