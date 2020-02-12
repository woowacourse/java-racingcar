package racingcar.view;

public class ValidateInput {

    public static final int NAME_LENGTH_LIMIT = 5;

    public static void isBlank(String input) {
        if (input.replace(" ", "").isEmpty()) {
            throw new IllegalArgumentException("공백이 입력되었습니다.");
        }
    }

    public static void isOverSixLetters(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 5자 이내로 작성해주세요.");
        }
    }

    public static void isNotNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new NumberFormatException("시도 횟수는 숫자를 입력해주세요.");
        }
    }
}
