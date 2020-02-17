package racingcar.domain;

public class Name {
    private static final int NAME_LENGTH_LIMIT = 5;

    private String name;

    public Name(String name) throws IllegalArgumentException {
        isCorrectName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void isCorrectName(String name) {
        isBlankValidation(name);
        isOverSixLetters(name);
    }

    private void isBlankValidation(String name) {
        if (name.replace(" ", "").isEmpty()) {
            throw new IllegalArgumentException("공백이 입력되었습니다.");
        }
    }

    private void isOverSixLetters(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 5자 이내로 작성해주세요.");
        }
    }
}