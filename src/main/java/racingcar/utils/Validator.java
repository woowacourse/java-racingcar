package racingcar.utils;

public class Validator {
    private static final int ZERO = 0;

    private Validator() {
    }

    // 시도 횟수 오류검증
    public static void validatePlayRound(String playRound) {
        if (!isValidPlayRound(playRound)) {
            throw new IllegalArgumentException("음수 입력 불가합니다.");
        }
    }

    private static boolean isValidPlayRound(String playRound) {
        try {
            return Integer.parseInt(playRound) > ZERO;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("1이상의 자연수만 입력 가능합니다.");
        }
    }
}
