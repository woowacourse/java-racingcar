package domain;

public class Car {
    public static final int ZERO = 0;
    public static final int NAME_UPPER_LIMIT = 5;
    private String name;

    public Car(String name) {
        validateNull(name);
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() <= ZERO || name.length() > NAME_UPPER_LIMIT) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하로 해주세요.");
        }
    }

    private void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null값이 될 수 없습니다.");
        }
    }
}
