package racingcar.domain.car;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Name(String name) {
        validateEmptyName(name);
        validateNameLength(name);

        this.name = name;
    }

    public static void validateEmptyName(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값은 빈 문자열일 수 없습니다.");
        }
    }

    public static void validateNameLength(String input) {
        if (isOverLength(input)) {
            throw new IllegalArgumentException("자동차의 이름은 5자이하만 가능합니다.");
        }
    }

    private static boolean isOverLength(String input) {
        return input.length() > MAX_NAME_LENGTH;
    }

    @Override
    public String toString() {
        return name;
    }
}
