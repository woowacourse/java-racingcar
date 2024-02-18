public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("공백을 이름으로 사용할 수 없습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름이 너무 깁니다. 이름은 5자 이하로 입력해 주세요.");
        }

    }

    public String getName() {
        return name;
    }
}
