package racingcar.domian.car;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Objects;

public class Car implements Comparable<Car>{
    private static final String EMPTY_STRING = "";
    private static final int INIT_POSITION = 0;
    private static final int NAME_LENGTH_LIMIT = 5;

    private String name;
    private Position position;

    public Car(String name) {
        this(new Position(INIT_POSITION), name);
    }

    public Car(Position position, String name) {
        this.position = position;
        this.name = validateName(name);
    }

    public Position getPosition() {
        return this.position;
    }

    public String getName() {
        return name;
    }

    private static String validateName(String name) {
        validateNullOrEmpty(name);
        validateNameLength(name);
        return name.trim();
    }

    private static void validateNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈 값 혹은 Null 입력입니다!");
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름 길이 5자 초과입니다!");
        }
    }

    public String isWinner(int max) {
        if (isMaxPosition(max)) {
            return name;
        }
        return EMPTY_STRING;
    }

    private boolean isMaxPosition(int max) {
        return this.position == max;
    }

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
        return Objects.hash(position, name);
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.position;
    }
}
