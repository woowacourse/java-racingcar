package racingcar.domain.car;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    Name(String name) {
        validateEmptyName(name);
        validateNameLength(name);
        this.name = name;
    }

    public static void validateEmptyName(String inputName) throws IllegalArgumentException {
        if (inputName.isEmpty()) {
            throw new IllegalArgumentException("입력값은 빈 문자열일 수 없습니다.");
        }
    }

    public static void validateNameLength(String inputName) {
        if (isOverLength(inputName)) {
            throw new IllegalArgumentException("자동차의 이름은 5자이하만 가능합니다.");
        }
    }

    private static boolean isOverLength(String inputName) {
        return inputName.length() > MAX_NAME_LENGTH;
    }

    @Override
    public String toString() {
        return name;
    }
}
