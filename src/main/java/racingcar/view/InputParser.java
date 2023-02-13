package racingcar.view;

import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.Arrays;
import java.util.List;

public class InputParser {

    private static final String DELIMITER = ",";
    private static final int SPLIT_LIMIT = -1;
    private static final String INVALID_COUNT_MESSAGE = "시도할 회수는 정수만 입력할 수 있습니다. 입력한 값 : ";

    public List<String> splitAndParseNames(final String input) {
        return Arrays.stream(input.split(DELIMITER, SPLIT_LIMIT))
                .map(String::trim)
                .collect(toUnmodifiableList());
    }

    public int parseInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_COUNT_MESSAGE + input);
        }
    }
}
