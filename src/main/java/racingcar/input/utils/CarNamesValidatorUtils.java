package racingcar.input.utils;

import java.util.List;
import java.util.regex.Pattern;

public class CarNamesValidatorUtils {
    private final static String VALID_CAR_NAME_PATTERN = "^[a-zA-Z0-9가-힣]{1,5}$";

    public static boolean isAllValidCarNames(List<String> inputCarNames) {
        return inputCarNames.stream()
            .allMatch(name -> Pattern.matches(VALID_CAR_NAME_PATTERN, name));
    }
}
