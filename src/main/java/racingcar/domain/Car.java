package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car implements Comparable<Car> {
    private static final int OPERATING_STANDARD = 4;
    private static final String STATUS_DELIMITER = " : ";
    private static final String POSITION_TO_STRING = "-";

    private String carName;
    private int position;
    private RandomNumberGenerator randomNumberGenerator;


    public Car(String carName, RandomNumberGenerator randomNumberGenerator) {
        this.carName = carName;
        this.position = 0;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void tryMoving() {
        if (isMovable()) {
            position++;
        }
    }

    public boolean isMovable() {
        return randomNumberGenerator.generate() >= OPERATING_STANDARD;
    }

    public String getCarName() {
        return this.carName;
    }

    @Override
    public int compareTo(Car other) {
        return other.position - this.position;
    }

    @Override
    public String toString() {
        return buildStatusView(new StringBuilder()).toString();
    }

    private StringBuilder buildStatusView(StringBuilder stringBuilder) {
        stringBuilder.append(carName).append(STATUS_DELIMITER);
        for (int i = 0; i < this.position; i++) {
            stringBuilder.append(POSITION_TO_STRING);
        }
        return stringBuilder;
    }
}
