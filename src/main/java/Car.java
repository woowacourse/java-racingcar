public class Car {

    private final CarName carName;
    private final CarLocation carLocation;

    private Car(CarName carName, CarLocation carLocation) {
        this.carName = carName;
        this.carLocation = carLocation;
    }

    public static Car fromName(String name) {
        return new Car(
                new CarName(name),
                new CarLocation()
        );
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            carLocation.increaseLocation(randomNumber);
        }
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getCarLocation() {
        return carLocation.getLocation();
    }
}
