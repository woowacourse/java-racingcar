package utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Validator {
    public static void checkDigits(String input) {
        boolean isMatch = input.matches("\\d+");
        if (!isMatch) {
            throw new IllegalArgumentException("[ERROR] : 시도 횟수는 숫자만 입력이 가능합니다.");
        }
    }

    public static void checkRange(int tryCount) {
        if (tryCount < 1 || tryCount > 100) {
            throw new IllegalArgumentException("[ERROR] : 시도 횟수는 1 이상 100 이하의 양의 정수만 가능합니다.");
        }
    }

    public static void checkBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("[ERROR] : 빈 이름은 들어올 수 없습니다");
        }
    }

    public static void checkLength(String carName) {
        if (carName.length() < 1 || carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] : 이름 길이는 1~5자 이하여야 합니다");
        }
    }

    public static void checkDuplication(String[] carNameArr) {
        Set<String> set = new HashSet<>(Arrays.asList(carNameArr));
        if (set.size() != carNameArr.length) {
            throw new IllegalArgumentException("[ERROR] : 자동차 이름이 중복되었습니다");
        }
    }
}
