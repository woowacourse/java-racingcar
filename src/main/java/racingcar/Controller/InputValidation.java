package racingcar.Controller;

public class InputValidation {

    public static void checkNullOrEmptyInput(String result) {
        if (result == null || result.isEmpty()) {
            throw new NullPointerException("입력이 null이나 빈 문자열입니다.");
        }
    }

    public static void checkSmallerThanSix(String result) {
        if (result.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이가 6 이상입니다.");
        }
    }
}
