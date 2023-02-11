package view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validate {
    static final String DIGIT = "\\d+";

    public void isValidCarNames(String[] carNames) {
        checkBlank(carNames);
        checkLength(carNames);
        checkDouble(carNames);
    }

    public void checkDigits(String input) {
        if (!input.matches(DIGIT)) {
            throw new IllegalArgumentException("[ERROR] : 숫자만 입력이 가능합니다.");
        }
    }

    public void checkRange(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException("[ERROR] : 1이상의 정수만 가능합니다.");
        }
    }

    private void checkBlank(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("[ERROR] : 빈 이름은 들어올 수 없습니다");
        }
    }

    private void checkLength(String[] carNames) {
        long invalidCount = Arrays.stream(carNames)
                .filter(names -> names.isEmpty() || names.length() > 5)
                .count();
        if (invalidCount != 0) {
            throw new IllegalArgumentException("[ERROR] : 이름 길이는 1~5자 이하여야 합니다");
        }
    }

    private void checkDouble(String[] carNames) {
        Set<String> set = new HashSet<>(Arrays.asList(carNames));
        if (set.size() != carNames.length) {
            throw new IllegalArgumentException("[ERROR] : 자동차 이름이 중복되었습니다");
        }
    }
}
