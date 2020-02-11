package racingcar.view;

public class ValidateInput {
    public static void isBlank(String input) {
        if (input.replace(" ", "").isEmpty()){
            throw new IllegalArgumentException("공백이 입력되었습니다.");
        }
    }
}
