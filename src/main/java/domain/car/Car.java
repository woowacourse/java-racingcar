package domain.car;

public class Car {
    private static final int START_POSITION = 0;

    private final CarName name;
    private final CarPosition position;
    private final DriveStrategy driveStrategy;

    private Car(CarName name, CarPosition position, DriveStrategy driveStrategy) {
        this.name = name;
        this.position = position;
        this.driveStrategy = driveStrategy;
    }

    public static Car createOnStart(String name, DriveStrategy driveStrategy) {
        return new Car(new CarName(name), new CarPosition(START_POSITION), driveStrategy);
    }

    public void move() {
        position.move(driveStrategy.drive());
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
