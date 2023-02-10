package racingcar.view.dto;

import racingcar.util.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CarNames {
    private static final String VALID_WORD_REGEX = "(\\w)+";
    private static final String SEPARATOR = ",";
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final Pattern CAR_NAME_PATTERN = Pattern.compile(VALID_WORD_REGEX);

    private final String carNames;

    public CarNames(String carNames) {
        validate(carNames);
        this.carNames = carNames;
    }

    private void validate(String carNames) {
        String[] splitCarNames = carNames.split(SEPARATOR);
        validateEmptyCarNames(splitCarNames);
        for (String splitCarName : splitCarNames) {
            validateWord(splitCarName);
            validateBlank(splitCarName);
            validateOverMaxLength(splitCarName);
        }

        validateDuplicateCarNames(splitCarNames);
    }

    private void validateEmptyCarNames(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_NULL.message());
        }
    }
    private void validateDuplicateCarNames(String[] splitCarNames) {
        int carNamesCount = splitCarNames.length;
        long distinctCount = Arrays.stream(splitCarNames).distinct().count();

        if (carNamesCount != distinctCount) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATED.message());
        }
    }

    private void validateBlank(String splitCarName) {
        if (splitCarName.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_NULL.message());
        }
    }

    private void validateWord(String splitCarName) {
        if (!CAR_NAME_PATTERN.matcher(splitCarName).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_FORMAT.message());
        }
    }

    private void validateOverMaxLength(String splitCarName) {
        if (splitCarName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_OVER_RANGE.message());
        }
    }

    public List<String> toSplitCarNames() {
        return Arrays.stream(carNames.split(SEPARATOR))
                .collect(Collectors.toList());
    }
}
