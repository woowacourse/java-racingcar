package domain;

public class Car {
    private static final int MOVE_BOUND_NUMBER = 4;

    private final CarName carName;
    private int position;

    public Car(CarName carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public static Car from(String name) {
        return new Car(new CarName(name), 0);
    }

    public void move(NumberGenerator numberGenerator) {
        if (numberGenerator.generate() >= MOVE_BOUND_NUMBER) {
            position++;
        }
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }
}
