package racingcar.view;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Parser {

    private static final String DELIMITER = ",";
    private static final int SPLIT_LIMIT = -1;
    private static final String INVALID_COUNT_MESSAGE =
            "입력된 횟수[{0}]: 횟수는 숫자만 가능합니다.";

    public List<String> parseNames(final String input) {
        return Arrays.stream(input.split(DELIMITER, SPLIT_LIMIT))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int parseCount(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MessageFormat.format(INVALID_COUNT_MESSAGE, input));
        }
    }
}
