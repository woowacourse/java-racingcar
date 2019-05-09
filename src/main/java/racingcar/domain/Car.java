package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        this.position++;
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
