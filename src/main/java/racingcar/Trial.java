package racingcar;

public class Trial {

    private static final Integer MIN_TRIAL = 1;
    private static final Integer MAX_TRIAL = Integer.MAX_VALUE;
    private static int trial;

    public Trial(String input) {
        validateNumber(input);
        validateBound();
    }

    public int getTrial() {
        return trial;
    }

    private static void validateNumber(String input) {
        try {
            trial = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                MIN_TRIAL + "이상 " + MAX_TRIAL + "이하의 숫자만 입력할 수 있습니다.");
        }
    }

    private static void validateBound() {
        if (trial < MIN_TRIAL) {
            throw new IllegalArgumentException(
                MIN_TRIAL + "이상의 숫자를 입력해주세요.");
        }
    }
}