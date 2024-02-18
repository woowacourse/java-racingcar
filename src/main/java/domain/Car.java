package domain;

public class Car implements Comparable<Car> {

    private static final int MIN_MOVE_NUMBER = 4;
    private static final int START_LOCATION = 0;
    private static final String REGEX = "^[a-zA-Z가-힣]{1,5}$";

    private final String name;
    private int location;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
        this.location = START_LOCATION;
    }

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    private void validateCarName(String name) {
        if (!name.matches(REGEX)) {
            throw new IllegalArgumentException(ExceptionMessages.CAR_NAME_FORMAT);
        }
    }

    public void move(int randomNumber) {
        if (randomNumber >= MIN_MOVE_NUMBER) {
            location++;
        }
    }

    public boolean isSameLocation(int furthestLocation) {
        return location == furthestLocation;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    @Override
    public int compareTo(Car car) {
        return this.location - car.getLocation();
    }
}
