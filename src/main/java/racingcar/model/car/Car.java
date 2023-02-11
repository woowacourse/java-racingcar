package racingcar.model.car;

import racingcar.model.car.strategy.MovingStrategy;
import racingcar.validator.CarNameValidator;

public class Car {
    private static final String POSITION_FORMAT_SYMBOL = "-";
    private static final String POSITION_STATE_FORMAT = "%s : %s";
    private static final int POSITION_INIT = 1;

    private final String carName;
    private int position;
    private final MovingStrategy movingStrategy;

    public Car(String carName, MovingStrategy movingStrategy) {
        CarNameValidator.validate(carName);

        this.carName = carName;
        this.position = POSITION_INIT;
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

    public String getCarName() {
        return carName;
    }
    public int getPosition() {
        return position;
    }
}
