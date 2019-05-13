package domain;

import util.StringUtils;

import java.util.Objects;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        if (name == null) {
            throw new NullPointerException("자동차의 이름을 입력해주세요.");
        }

        if (!StringUtils.isCarNameLength(name)) {
            throw new IllegalArgumentException("각 자동차의 이름을 1자 이상, 5자 이하로 입력해주세요.");
        }

        this.name = name.trim();
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void moveForeword() {
        position ++;
    }

    public int getBiggerPosition(int comparePosition) {
        return Math.max(position, comparePosition);
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }

    @Override
    public String toString() {
        String trace = new String(new char[position]).replace("\0", "-");
        return name + " : " + trace;
    }

    /* equals, hashCode > 상태를 가지는 객체들에게 필수적인 메서드 */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
