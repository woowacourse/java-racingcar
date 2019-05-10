package racinggame.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static final int TRIAL_MIN = 1;

    public static void checkCarNames(List<String> carNames) {
       if (checkNameDuplication(carNames)) {
            throw new IllegalArgumentException("중복되는 이름은 입력할 수 없습니다.");
        }
    }

    public static boolean checkNameDuplication(List<String> carNames) {
        Set<String> nameSet = new HashSet<>(carNames);

        return nameSet.size() != carNames.size();
    }

    public static void checkPositiveNumber(int trial) {
        if (trial < TRIAL_MIN) {
            throw new IllegalArgumentException("시도횟수는 양의 정수여야 합니다.");
        }
    }
}
