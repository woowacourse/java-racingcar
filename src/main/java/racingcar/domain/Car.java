package racingcar.domain;

public class Car {
    private static final int THRESHOLD = 4;

    private final String name;
    private final Engine engine;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.engine = new Engine();
        this.position = position;
    }

    public void move(int power) {
        if (power >= THRESHOLD) {
            position++;
        }
    }

    public void move() {
        move(startEngine());
    }

    public int startEngine() {
        return engine.ignite();
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
