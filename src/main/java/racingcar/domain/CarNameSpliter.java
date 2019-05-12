package racingcar.domain;

public class CarNameSpliter {
    private static final String SPLIT_REGEX = ",";

    public static String[] splitCarNames(String carNames) {
        checkContinuousComma(carNames);
        return carNames.split(SPLIT_REGEX);
    }

    private static void checkContinuousComma(String carNames) {
        if (carNames.contains(",,")) {
            throw new IllegalArgumentException("연속된 콤마가 발견 되었습니다.");
        }
    }
}
