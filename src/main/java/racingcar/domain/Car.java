package racingcar.domain;

public class Car implements Comparable<Car> {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public void moveOrHold(Boolean isMove) {
        if (isMove) {
            this.position++;
        }
    }

    public boolean isSamePosition(Car targetCar) {
        return targetCar.decideIsSame(position);
    }

    public boolean decideIsSame(int targetPosition) {
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

    public int getCompareToValue(int targetPosition) {
        return targetPosition - position;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
