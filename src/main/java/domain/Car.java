package domain;

public class Car implements Comparable<Car> {
    private static final int STANDARD = 4;
    private final String name;
    private int location = 0;

    public Car(String name) {
        Validator.validateCarName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return String.format(FORMAT, name, "-".repeat(location));
    }

    public void move(int randomNumber) {
        if (randomNumber >= STANDARD) {
            location++;
        }
    }


    public int getLocation() {
        return location;
    }

    @Override
    public int compareTo(Car car) {
        return this.location - car.getLocation();
    }
}
