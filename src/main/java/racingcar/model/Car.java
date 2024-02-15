package racingcar.model;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return this.name + " : " + "-".repeat(this.position);
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }
}
