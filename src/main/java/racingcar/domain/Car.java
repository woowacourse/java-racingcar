package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car {
    private final CarName name;
    private int position;

    public Car(String carName, int position) {
        this.name = new CarName(carName);
        this.position = position;
    }

    public void move() {
        position++;
    }

    public String getName() {
        return name.getCarName();
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePositionWith(int fastestPosition) {
        return this.position == fastestPosition;
    }
}
