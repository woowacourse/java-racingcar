package racingcargame.domain;

public class CarName {
    private static final int ZERO = 0;
    private static final int NAME_UPPER_LIMIT = 5;

    private String name;

    public CarName(String name) {
        validateNotNull(name);
        validateLength(name);
        validateNoBlank(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() <= ZERO || name.length() > NAME_UPPER_LIMIT || name.contains(",")) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

    private void validateNotNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null값이 될 수 없습니다.");
        }
    }

    private void validateNoBlank(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("이름에는 띄어쓰기가 포함될 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
