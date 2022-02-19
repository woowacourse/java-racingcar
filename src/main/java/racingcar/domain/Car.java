package racingcar.domain;

public class Car implements Comparable<Car>, Vehicle {
    private final String name;
    private int position;

    private Car(CarBuilder carbuilder) {
        this.name = carbuilder.name;
    }

    public static CarBuilder carBuilder(){
        return new CarBuilder();
    }

    public void moveOrHold(Boolean isMove) {
        if (isMove) {
            this.position++;
        }
    }

    public boolean isSamePosition(Car targetCar) {
        return targetCar.decideIsSame(position);
    }

    private boolean decideIsSame(int targetPosition) {
        return position == targetPosition;
    }

    public int getPositionForTest() {
        return position;
    }

    public String getNameForTest() {
        return name;
    }

    @Override
    public int compareTo(Car s) {
        return s.getCompareToValue(position);
    }

    private int getCompareToValue(int targetPosition) {
        return targetPosition - position;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
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
