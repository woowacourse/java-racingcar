package racingcar.input.utils.carname;

import java.util.List;
import java.util.regex.Pattern;
import racingcar.input.utils.carname.exception.InvalidCarNameFormatException;

public class CarNameFormatValidatorUtils {
    private final static String VALID_CAR_NAME_PATTERN = "^[a-zA-Z0-9가-힣]{1,5}$";

    public static void isAllValidCarNames(List<String> inputCarNames) {
        if (inputCarNames.stream()
            .allMatch(name -> Pattern.matches(VALID_CAR_NAME_PATTERN, name))) {
            throw new InvalidCarNameFormatException(
                "자동차 이름은 1자 이상, 5자 이하의 숫자나 문자로만 구성되어야 합니다."
            );
        }
    }
}
