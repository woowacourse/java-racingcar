package racingcar.domain.Car;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(final String name) {
        this.name = validate(name);
    }

    private String validate(String name) {
        validateNullOrEmpty(name);
        validateLength(name);
        return name.trim();
    }

    private void validateNullOrEmpty(String name) {
        if (name == null || "".equals(name.trim())) {
            throw new RuntimeException("이름은 공백이거나 빈 문자열이 될 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        name = name.trim();
        if (name.length() < 1 || name.length() > 5) {
            throw new RuntimeException("이름은 1글자 이상 5글자 이하여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CarName{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(this.name, name.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
