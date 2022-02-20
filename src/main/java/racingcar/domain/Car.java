package racingcar.domain;

public class Car implements Comparable<Car>, Vehicle {
    private final String name;
    private int position;

    private Car(CarBuilder carbuilder) {
        this.name = carbuilder.name;
    }

    public static CarBuilder carBuilder() {
        return new CarBuilder();
    }

    public void moveOrHold(Boolean isMove) {
        if (isMove) {
            this.position++;
        }
    }

    public boolean isSamePosition(Car targetCar) {
        return position == targetCar.getPosition();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car s) {
        return position - s.getPosition();
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, "-".repeat(position));
    }

    public static class CarBuilder {
        private String name;

        public CarBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
