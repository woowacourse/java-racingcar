package racingcar.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import racingcar.domain.input.carname.validator.exception.InvalidCarNameFormatException;

public class Car {
    private final String name;
    private int position;
    private final static Pattern CAR_NAME_FORMAT_PATTERN
        = Pattern.compile("^[a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]{1,5}$");

    public Car(String name) {
        Matcher carNameFormatPatternMatcher = CAR_NAME_FORMAT_PATTERN.matcher(name);
        if (!carNameFormatPatternMatcher.find()) {
            throw new InvalidCarNameFormatException(
                "자동차 이름은 1자 이상, 5자 이하의 숫자나 문자로만 구성되어야 합니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void goForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
