package view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    private static final String DIGIT = "\\d+";
    private static final String TRYCOUNT_NONDIGIT_ERROR_MESSAGE = "[ERROR] : 숫자만 입력이 가능합니다.";
    private static final String TRYCOUNT_RANGE_ERROR_MESSAGE = "[ERROR] : 1이상의 정수만 가능합니다.";
    private static final String CARNAMES_BLANK_ERROR_MESSAGE = "[ERROR] : 빈 이름은 들어올 수 없습니다";
    private static final String CARNAMES_LENGTH_ERROR_MESSAGE = "[ERROR] : 이름 길이는 1~5자 이하여야 합니다";
    private static final String CARNAMES_DUPLICATE_ERROR_MESSAGE = "[ERROR] : 자동차 이름이 중복되었습니다";

    public void checkValidCarNames(String[] carNames) {
        checkBlank(carNames);
        checkLength(carNames);
        checkDouble(carNames);
    }

    public void checkDigits(String input) {
        if (!input.matches(DIGIT)) {
            throw new IllegalArgumentException(TRYCOUNT_NONDIGIT_ERROR_MESSAGE);
        }
    }

    public void checkRange(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException(TRYCOUNT_RANGE_ERROR_MESSAGE);
        }
    }

    private void checkBlank(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException(CARNAMES_BLANK_ERROR_MESSAGE);
        }
    }

    private void checkLength(String[] carNames) {
        long invalidCount = Arrays.stream(carNames)
                .filter(name -> name.isEmpty() || name.length() > 5)
                .count();
        if (invalidCount != 0) {
            throw new IllegalArgumentException(CARNAMES_LENGTH_ERROR_MESSAGE);
        }
    }

    private void checkDouble(String[] carNames) {
        List<String> nonDuplicatedCarNames = Arrays.stream(carNames).distinct().collect(Collectors.toList());
        if (nonDuplicatedCarNames.size() != carNames.length) {
            throw new IllegalArgumentException(CARNAMES_DUPLICATE_ERROR_MESSAGE);
        }

    }
}
