package racingcar.model.car;

import java.util.regex.Pattern;
import racingcar.util.ErrorMessage;

public class CarName {
    private static final String VALID_WORD_REGEX = "(\\w)+";
    private static final Pattern CAR_NAME_PATTERN = Pattern.compile(VALID_WORD_REGEX);
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private final String carName;

    public CarName(String carName) {
        validate(carName);
        this.carName = carName;
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
}
