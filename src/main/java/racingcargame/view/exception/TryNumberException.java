package racingcargame.view.exception;

public class TryNumberException {

    private static final int MIN_TRY_NUMBER = 1;

    public static void checkExceedRange(int input) {
        if (input < MIN_TRY_NUMBER) {
            throw new RuntimeException("1 이상의 숫자만 입력 가능합니다.");
        }
    }
}
