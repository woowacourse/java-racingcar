package racingcar.view.dto;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        validateFormat(carNames);
        //TODO 각각의 길이가 5자 이하
    }

    private void validateFormat(String carNames) {
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
            throw new IllegalArgumentException("[ERROR] 중복된 차 이름이 존재합니다.");
        }
    }

    private void hasBlank(String splitCarName) {
        if (splitCarName.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 비어있는 자동차 이름이 들어있습니다.");
        }
    }

    private void hasInvalidValue(String splitCarName) {
        Pattern pattern = Pattern.compile(VALID_STRING_REGEX);
        if (!pattern.matcher(splitCarName).matches()) {
            throw new IllegalArgumentException("[ERROR] 문자와 숫자가 아닌 자동차 이름이 들어있습니다.");
        }
    }

    private void isOverMaxLength(String splitCarName) {
        if (splitCarName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 다섯 글자가 넘는 자동차 이름이 들어있습니다.");
        }
    }

    public List<String> toCarNameList() {
        return Arrays.stream(carNames.split(SEPARATOR))
                .collect(Collectors.toList());
    }
}