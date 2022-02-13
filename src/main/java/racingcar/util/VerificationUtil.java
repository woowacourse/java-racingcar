package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;

public class VerificationUtil {

    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private VerificationUtil() {
    }

    public static void validateCarName(String carName) {
        validateCarNameLength(carName);
        validateCarNameSpace(carName);
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() < CAR_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1글자 이상이어야 합니다.");
        }

        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이하이어야 합니다.");
        }
    }

    private static void validateCarNameSpace(String carName) {
        if (carName.contains(" ")){
            throw new IllegalArgumentException("[ERROR] 공백 없이 입력해주세요.");
        }
    }

    public static void validateDuplication(String[] carNames) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(carNames));

        if (hashSet.size() < carNames.length) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 중복되면 안됩니다.");
        }
    }


    public static void validateAttempt(String attempt) {
        int number = translateVerifiedInteger(attempt);
        validatePositiveNumber(number);
    }

    private static int translateVerifiedInteger(String attempt) {
        try {
            return Integer.parseInt(attempt);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }

    private static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해주세요.");
        }
    }
}
