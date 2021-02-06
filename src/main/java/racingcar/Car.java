package racingcar;

import java.util.stream.IntStream;

public class Car {

    private int position;
    private final String name;

    private Car(final String name) {
        this.position = 1;
        this.name = name;
    }

    public static Car from(final String name) {
        return new Car(getValidatedName(name));
    }

    private static String getValidatedName(String name) {
        name = name.trim();
        validateNameLength(name);
        validateNameNullOrEmpty(name);
        return name;
    }

    private static void validateNameNullOrEmpty(String name) {
        if (name == null || "".equals(name)) {
            throw new RuntimeException();
        }
    }

    private static void validateNameLength(String name) {
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

    @Override
    public String toString() {
        String a = name + " : ";
        return a + getPositionToString();
    }

    private String getPositionToString() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, position)
                .forEach(i -> sb.append("-"));
        return sb.toString();
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
