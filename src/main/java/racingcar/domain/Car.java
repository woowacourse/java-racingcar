package racingcar.domain;

public class Car implements Comparable<Car> {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void moveOrHold(Boolean isMove) {
        if (isMove) {
            this.position++;
        }
    }

    public void printPosition() {
        System.out.print(name + " : ");
        System.out.println("-".repeat(position));
    }

    public boolean isSamePosition(Car maxCar) {
        return position == maxCar.getPosition();
    }

    public int compareTo(Car s) {
        return position - s.getPosition();
    }
}
