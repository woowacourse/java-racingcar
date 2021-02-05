package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void goForward() { position++; }

    public int getPosition() {
        return position;
    }
}
