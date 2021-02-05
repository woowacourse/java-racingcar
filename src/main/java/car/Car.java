package car;

import java.util.Objects;

public class Car {
    private final Name carName;
    
    private final Position position;
    
    public Car(String carName) {
        this(new Name(carName));
    }
    
    public Car(Name carName) {
        this(carName, new Position());
    }
    
    public Car(String carName, int position) {
        this(new Name(carName), new Position(position));
    }
    
    public Car(Name carName, Position position) {
        this.carName = carName;
        this.position = position;
    }
    
    public Car move() {
        return new Car(carName, position.move());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(position, car.position);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
