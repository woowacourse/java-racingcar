package racingCar;

import java.util.Objects;

public class Car {
    private final CarName carName;
    private Distance distance;

    public Car(final String name) {
        this.carName = new CarName(name);
        this.distance = new Distance(0);
    }

    public Car(String name, int distance){
        this.carName = new CarName(name);
        this.distance = new Distance(distance);
    }

    public void move(int number) {
        distance.move(number);
    }

    public boolean isWinner(int max) {
        return distance.isMaxDistance(max);
    }

    public CarName getName() {
        return carName;
    }

    public int getDistance() {
        return distance.getDistance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (!Objects.equals(carName, car.carName)) return false;
        return Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        int result = carName != null ? carName.hashCode() : 0;
        result = 31 * result + (distance != null ? distance.hashCode() : 0);
        return result;
    }
}
