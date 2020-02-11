package domain;

public class Car {
    public Car() {
    }

    public void validateName(String name) {
        if (name.length() <= 0 || name.length() > 5) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하로 해주세요.");
        }
    }

    public void validateNull(Object o) {
        if (o==null) throw new IllegalArgumentException("이름은 null값이 될 수 없습니다.");
    }
}
