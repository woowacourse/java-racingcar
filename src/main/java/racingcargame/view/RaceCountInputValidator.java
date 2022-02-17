package racingcargame.view;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class RaceCountInputValidator {
    private static final Pattern RACE_COUNT_PATTERN = Pattern.compile("[0-9]+");
    private static final String NOT_RIGHT_COUNT_ERROR_MESSAGE = "[error] 경주횟수는 0부터 9까지의 숫자만 입력해주세요.";
    private static final String EMPTY_RACE_COUNT_ERROR_MESSAGE = "[error] 경주횟수를 입력해주세요.";

    private RaceCountInputValidator() {
    }

    public static String validateRaceCountInput(String raceCount) {
        if (isRightNumberRaceCount(raceCount)) {
            return raceCount;
        }
        throw new IllegalArgumentException();
    }

    private static boolean isRightNumberRaceCount(String raceCount) {
        if (StringUtils.isBlank(raceCount)) {
            throw new IllegalArgumentException(EMPTY_RACE_COUNT_ERROR_MESSAGE);
        }
        if (!RACE_COUNT_PATTERN.matcher(raceCount).matches()) {
            throw new IllegalArgumentException(NOT_RIGHT_COUNT_ERROR_MESSAGE);
        }
        return true;
    }
}
