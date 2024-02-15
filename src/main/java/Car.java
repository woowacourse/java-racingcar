public class Car implements Comparable<Car>, Movable {

    private final String name;
    private int location = 0;

    public Car(String name) {
        Validator.validateCarName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void move() {
        int randomNumber = RandomGenerator.getRandomNumber();
        if (randomNumber >= 4) {
            location++;
        }
    }

    @Override
    public int getLocation() {
        return location;
    }

    @Override
    public int compareTo(Car car) {
        return this.location - car.getLocation();
    }
}
