package racingcar.domain;

public class Name {
    public static final int NAME_LENGTH_LIMIT = 5;
    private String name;


    public Name(String name) throws IllegalArgumentException {
        this.name = name;
        isCorrectName();
    }

    public String getName() {
        return name;
    }

    public void isCorrectName() throws IllegalArgumentException {
        isBlankValidation();
        isOverSixLetters();
    }

    private void isBlankValidation() {
        if (name.replace(" ", "").isEmpty()) {
            throw new IllegalArgumentException("공백이 입력되었습니다.");
        }
    }

    private void isOverSixLetters() {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 5자 이내로 작성해주세요.");
        }
    }
}