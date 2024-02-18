package domain.car;

public class Car {
    private static final int START_POSITION = 0;

    private final CarName name;
    private final CarPosition position;

    private Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public static Car createOnStart(String name) {
        return new Car(new CarName(name), new CarPosition(START_POSITION));
    }

    public void move(int distance) {
        position.move(distance);
    }

    public boolean isSamePosition(int maxPosition) {
        return position.getPosition() == maxPosition;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
