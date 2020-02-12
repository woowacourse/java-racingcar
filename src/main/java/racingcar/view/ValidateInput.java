package racingcar.view;

public class ValidateInput {
    public static void isBlank(String input) {
        if (input.replace(" ", "").isEmpty()) {
            throw new IllegalArgumentException("공백이 입력되었습니다.");
        }
    }

    public static void isOverSixLetters(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이내로 작성해주세요.");
        }
    }
}
