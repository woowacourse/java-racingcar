package racingcar.receiver;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import racingcar.exception.CarNameException;

public class CarNamesReceiver {

    public static final String INVALID_LENGTH_ERROR_MESSAGE = "자동차 이름은 5글자 이하여야 합니다.";
    public static final String EMPTY_NAME_ERROR_MESSAGE = "자동차 이름은 공백일 수 없습니다.";
    public static final String DUPLICATE_NAME_ERROR_MESSAGE = "자동차 이름은 중복일 수 없습니다.";
    private static final int NAME_UPPER_LENGTH = 5;
    private static final String NAME_DELIMITER = ",";

    public String validateCarNames(String names) {
        checkNameLength(names);
        checkEmptyName(names);
        checkDuplicateName(names);
        return names;
    }

    public List<String> parseNames(String names) {
        return Arrays.stream(splitByDelimiter(names))
                .collect(toList());
    }

    private void checkNameLength(String names) {
        if (isInvalidLength(names)) {
            throw new CarNameException(INVALID_LENGTH_ERROR_MESSAGE);
        }
    }

    private void checkEmptyName(String names) {
        if (isEmptyName(names)) {
            throw new CarNameException(EMPTY_NAME_ERROR_MESSAGE);
        }
    }

    private void checkDuplicateName(String names) {
        if (isDuplicateName(names)) {
            throw new CarNameException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }

    private boolean isInvalidLength(String names) {
        return Arrays.stream(splitByDelimiter(names))
                .anyMatch(n -> n.length() > NAME_UPPER_LENGTH);
    }

    private boolean isEmptyName(String names) {
        return Arrays.stream(splitByDelimiter(names))
                .anyMatch(String::isEmpty);
    }

    private boolean isDuplicateName(String names) {
        return Arrays.stream(splitByDelimiter(names))
                .distinct()
                .count() != splitByDelimiter(names).length;
    }

    private String[] splitByDelimiter(String names) {
        return names.split(NAME_DELIMITER);
    }
}
