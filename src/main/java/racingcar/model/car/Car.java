package racingcar.model.car;

import racingcar.exception.ExceedCarNameLengthException;
import racingcar.exception.HasBlankCarNameException;
import racingcar.exception.InvalidCarNameFormatException;
import racingcar.model.car.strategy.MovingStrategy;

import java.util.regex.Pattern;

public class Car {
    private static final int POSITION_INIT = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final Pattern STRING_PATTERN = Pattern.compile("(\\w)+");

    private final String carName;
    private int position;
    private final MovingStrategy movingStrategy;

    public Car(String carName, MovingStrategy movingStrategy) {
        validate(carName);

        this.carName = carName;
        this.position = POSITION_INIT;
        this.movingStrategy = movingStrategy;
    }

    private void validate(String carName) {
        validateValue(carName);
        validateHasBlank(carName);
        validateOverMaxNameLength(carName);
    }

    private void validateValue(String carName) {
        if (!STRING_PATTERN.matcher(carName).matches()) {
            throw new InvalidCarNameFormatException();
        }
    }

    private void validateHasBlank(String carName) {
        if (carName.isBlank()) {
            throw new HasBlankCarNameException();
        }
    }

    private void validateOverMaxNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new ExceedCarNameLengthException();
        }
    }

    public void moveForward() {
        position++;
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
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
