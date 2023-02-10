package racingcar.model.car;

import racingcar.model.car.strategy.MovingStrategy;

public class Car {
    private static final String POSITION_FORMAT_SYMBOL = "-";
    private static final String POSITION_STATE_FORMAT = "%s : %s";
    private static final int POSITION_INIT = 1;

    private final String carName;
    private int position = POSITION_INIT;
    private final MovingStrategy movingStrategy;

    public Car(String carName, MovingStrategy movingStrategy) {
        this.carName = carName;
        this.movingStrategy = movingStrategy;
    }

    public void moveForward() {
        position++;
    }

    public String getCurrentStateFormat() {
        String positionFormat = POSITION_FORMAT_SYMBOL.repeat(position);
        return String.format(POSITION_STATE_FORMAT, carName, positionFormat);
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }

    public String getWinnerCarNameFormat() {
        return carName;
    }

    public boolean movable() {
        return movingStrategy.movable();
    }

    public int getPosition() {
        return position;
    }
}
