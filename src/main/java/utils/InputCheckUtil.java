package utils;

public class InputCheckUtil {

    public static void inputValidate(String input) {
        if (input.charAt(0) == ',' || input.charAt(input.length() - 1) == ',') {
            throw new IllegalArgumentException("시작이나 끝에 콤마(,)가 올 수 없습니다.");
        }
    }
}
