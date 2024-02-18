package racing.domain;

import java.util.regex.Pattern;

public class Car implements Comparable<Car> {

    private final String name;
    private int distance;

    public Car(int distance, String name) {
        validateName(name);
        this.distance = distance;
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new RuntimeException("이름의 길이는 1 이상 5 이하여야 합니다.");
        }
        if (!Pattern.matches("^[a-zA-Z]+$", name)) {
            throw new RuntimeException("이름은 알파벳 대소문자로만 이루어져야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;

        if (distance != car.distance) {
            return false;
        }
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        int result = distance;
        result = 31 * result + name.hashCode();
        return result;
    }

    void go() {
        distance += 1;
    }

    void stop() {
    }

    @Override
    public int compareTo(Car o) {
        return o.distance - distance;
    }

    boolean hasSameDistance(Car other) {
        return distance == other.distance;
    }

    String getName() {
        return name;
    }

    int getDistance() {
        return distance;
    }
}
