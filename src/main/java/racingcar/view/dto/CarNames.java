package racingcar.view.dto;

import racingcar.util.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CarNames {
    private static final String VALID_STRING_REGEX = "(\\w)+";
    private static final String SEPARATOR = ",";
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private String carNames;

    public CarNames(String carNames) {
        validate(carNames);
        this.carNames = carNames;
    }

    private void validate(String carNames) {
        String[] splitCarNames = carNames.split(SEPARATOR);

        for (String splitCarName : splitCarNames) {
            hasInvalidValue(splitCarName);
            hasBlank(splitCarName);
            isOverMaxLength(splitCarName);
        }

        validateDuplicateCarNames(splitCarNames);
    }

    private void validateDuplicateCarNames(String[] splitCarNames) {
        int carNamesCount = splitCarNames.length;
        long distinctCount = Arrays.stream(splitCarNames).distinct().count();

        if (carNamesCount != distinctCount) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATED.message());
        }
    }

    private void hasBlank(String splitCarName) {
        if (splitCarName.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_NULL.message());
        }
    }

    private void hasInvalidValue(String splitCarName) {
        Pattern pattern = Pattern.compile(VALID_STRING_REGEX);
        if (!pattern.matcher(splitCarName).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_FORMAT.message());
        }
    }

    private void isOverMaxLength(String splitCarName) {
        if (splitCarName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_OVER_RANGE.message());
        }
    }

    public List<String> toCarNameList() {
        return Arrays.stream(carNames.split(SEPARATOR))
                .collect(Collectors.toList());
    }
}