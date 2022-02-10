package racingcar.domain;

public class Car implements Comparable<Car> {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        position++;
    }

    public void drive() {
        if (hasNext()) {
            move();
        }
    }

    public boolean hasNext() {
        int moveFlag = (int) (Math.random() * 100) % 10;
        return moveFlag > 3;
    }

    public boolean isSamePosition(Car other) {
        return this.position == other.position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String positions = "";
        for (int i = 0; i < position; i++) {
            positions += "-";
        }
        return String.format("%s : %s", name, positions);
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.position;
    }
}
