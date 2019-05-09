package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position++;
    }

    public boolean isFartherPosition(int position) {
        return this.position > position;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        String output = name + " : ";

        for (int i = 0; i < position; i++) {
            output += "-";
        }
        return output;
    }
}
