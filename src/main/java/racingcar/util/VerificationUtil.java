package racingcar.util;

public class VerificationUtil {

    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private VerificationUtil() {
    }

    public static void validateCarName(String carName) {
        if (carName.length() < CAR_NAME_MIN_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1글자 이상이어야 합니다.");
        }

        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이하이어야 합니다.");
        }
    }
}
