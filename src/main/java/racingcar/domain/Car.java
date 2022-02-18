package racingcar.domain;

public class Car {
    private static final int RANDOM_CONDITION = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void goForward(int number) {
        if (number >= RANDOM_CONDITION) {
            position += 1;
        }
    }

    public boolean isAlsoWinner(Car winner) {
        return position == winner.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
