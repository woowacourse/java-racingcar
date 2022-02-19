package racingcar.util;

import java.util.Arrays;
import java.util.List;
import racingcar.validator.InputValidator;

public class StringUtil {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int SPLIT_WITH_EMPTY = -1;

    public static List<String> split(String carNamesLine) {
        List<String> carNames = Arrays.asList(carNamesLine.split(CAR_NAME_DELIMITER, SPLIT_WITH_EMPTY));
        return carNames;
    }

    public static int getTrialCount(String line) {
        InputValidator.checkTrialCountLine(line);
        return Integer.parseInt(line);
    }
}
