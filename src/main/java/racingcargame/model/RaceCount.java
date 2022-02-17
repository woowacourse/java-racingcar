package racingcargame.model;

import java.util.regex.Pattern;

public class RaceCount {
    private static final String RACE_COUNT_PATTERN = "[0-9]+";
    private static final String INCORRECT_START_COUNT = "0";
    private static final String NOT_RIGHT_COUNT_ERROR_MESSAGE = "[error] 경주횟수는 0부터 9까지의 숫자만 입력해주세요.";
    private static final String RACE_COUNT_START_ZERO_ERROR_MESSAGE = "[error] 경주횟수는 1이상의 값을 입력해주세요.";
    private static final String EMPTY_RACE_COUNT_ERROR_MESSAGE = "[error] 경주횟수를 입력해주세요.";

    private int count;

    public RaceCount(String count) {
        this.count = checkRightCount(count);
    }

    private int checkRightCount(String count) {
        if (count == null) {
            throw new IllegalArgumentException(EMPTY_RACE_COUNT_ERROR_MESSAGE);
        }
        if (!Pattern.matches(RACE_COUNT_PATTERN, count)) {
            throw new IllegalArgumentException(NOT_RIGHT_COUNT_ERROR_MESSAGE);
        }
        if (count.startsWith(INCORRECT_START_COUNT)) {
            throw new IllegalArgumentException(RACE_COUNT_START_ZERO_ERROR_MESSAGE);
        }
        return Integer.parseInt(count);
    }

    public void reduceCount() {
        count--;
    }

    public int getCount() {
        return count;
    }
}
