package racingcar.view.dto;

import java.util.regex.Pattern;

public class CarNames {

    private static final String VALID_STRING_REGEX = "([\\\\w])+";
    private static final String SEPARATOR = ",";

    public CarNames(String carNames) {
        validate(carNames);
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


}