package racingcar.util;

public class Validation {
    public static void validateCarNameLength(final String carName) {
        if (carName.isEmpty() || carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
        }
    }
}
