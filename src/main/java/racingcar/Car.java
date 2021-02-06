package racingcar;

import java.util.stream.IntStream;

public class Car {
    private int position;
    private final String name;

    public Car(final String name) {
        this.position = 1;
        this.name = validateName(name);
    }

    private String validateName(String name) {
        name = name.trim();
        validateNameLength(name);
        validateNameNullOrEmpty(name);
        return name;
    }

    private void validateNameNullOrEmpty(String name) {
        if (name == null || "".equals(name)) {
            throw new RuntimeException();
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new RuntimeException();
        }
    }

    public void drive(int randomValue) {
        if (randomValue < 0 || randomValue > 9) {
            throw new RuntimeException();
        }

        if (randomValue >= 4) {
            accelerate();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void accelerate() {
        position++;
    }

    private String getPositionToString() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, position)
                .forEach(i -> sb.append("-"));
        return sb.toString();
    }

    @Override
    public String toString() {
        String a = name + " : ";
        return a + getPositionToString();
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Car) {
            Car car = (Car) obj;
            return this.name.equals(car.name);
        }
        return false;
    }
}