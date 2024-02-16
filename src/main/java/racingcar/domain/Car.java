package racingcar.domain;

public class Car {

    private static final int SPEED = 1;

    private final Name name;
    private final Engine engine;
    private int position = 0;


    public Car(final String name, final Engine engine) {
        this.name = new Name(name);
        this.engine = engine;
    }

    public void move() {
        engine.tryToWork();
        if (engine.isWorking()) {
            position += SPEED;
        }
    }

    public CarStatus getStatus() {
        return new CarStatus(name.getValue(), position);
    }
}
