package racingcar.Controller;

public class InputValidation {

    public static boolean isSmallerThanSix(String result) {
        if (result.isEmpty() || result.length() > 5) {
            return false;
        }
        return true;
    }

    public static void checkNullOrEmptyInput(String result) {
        if (result == null || result.isEmpty()) {
            throw new NullPointerException("입력이 null이나 빈 문자열입니다.");
        }
    }
}
