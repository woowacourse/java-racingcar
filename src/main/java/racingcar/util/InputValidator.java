package racingcar.util;

import java.util.List;

public class InputValidator {
    public static void validateCarName(List<String> carNameList) {
        if (!carNameList.stream().allMatch(carName -> carName.length() <= 5)) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }
}
