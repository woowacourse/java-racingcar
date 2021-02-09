package racingcar.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.domain.input.carname.validator.exception.InvalidCarNameFormatException;

public class Car {
    private final String name;
    private int position;
    private static final Pattern CAR_NAME_FORMAT_PATTERN
        = Pattern.compile("^[a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]{1,5}$");
    private static final int MIN_NUMBER_TO_GO_FORWARD = 4;

    public Car(String name) {
        validateCarNameFormat(name);
        this.name = name;
    }

    private void validateCarNameFormat(String name) {
        Matcher carNameFormatPatternMatcher = CAR_NAME_FORMAT_PATTERN.matcher(name);
        if (!carNameFormatPatternMatcher.find()) {
            throw new InvalidCarNameFormatException(
                "자동차 이름은 1자 이상, 5자 이하의 숫자나 문자로만 구성되어야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public void goForwardDependsOnNumber(int number) {
        if (number >= MIN_NUMBER_TO_GO_FORWARD) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
