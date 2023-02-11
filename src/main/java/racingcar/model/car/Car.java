package racingcar.model.car;

import java.util.regex.Pattern;
import racingcar.model.car.strategy.MovingStrategy;
import racingcar.util.ErrorMessage;

public class Car {
    private static final String VALID_WORD_REGEX = "(\\w)+";
    private static final Pattern CAR_NAME_PATTERN = Pattern.compile(VALID_WORD_REGEX);
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int DEFAULT_POSITION = 1;

    private final String carName;
    private int position = DEFAULT_POSITION;
    private final MovingStrategy movingStrategy;

    public Car(String carName, MovingStrategy movingStrategy) {
        validate(carName);
        this.carName = carName;
        this.movingStrategy = movingStrategy;
    }

    public void moveForward() {
        position += 1;
    }

    public boolean matchPosition(int otherPosition) {
        return position == otherPosition;
    }

    public boolean movable() {
        return movingStrategy.movable();
    }

    private void validate(String carName) {
        validateValidWord(carName);
        validateOverMaxLength(carName);
    }

    private void validateValidWord(String splitCarName) {
        if (!CAR_NAME_PATTERN.matcher(splitCarName).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_FORMAT.message());
        }
    }

    private void validateOverMaxLength(String splitCarName) {
        if (splitCarName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_OVER_RANGE.message());
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
