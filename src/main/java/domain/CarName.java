package domain;

public class CarName {
    private String name;

    public CarName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하입니다.");
        }
        if (name.length() < 1) {
            throw new IllegalArgumentException("자동차 이름은 한 글자 이상입니다.");
        }
    }

    public String getName() {
        return name;
    }
}

