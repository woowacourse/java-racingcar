package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car {
    private static final int OPERATING_STANDARD = 4;

    private final CarName name;
    private int position;

    public Car(String carName, int position) {
        this.name = new CarName(carName);
        this.position = position;
    }

    public void tryToMoveBy(RandomNumberGenerator randomNumberGenerator) {
        if (isMovableBy(randomNumberGenerator)) {
            position++;
        }
    }

    private boolean isMovableBy(RandomNumberGenerator randomNumberGenerator) {
        return randomNumberGenerator.generate() >= OPERATING_STANDARD;
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
