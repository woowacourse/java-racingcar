package car;

import java.util.Objects;

public class Car {
    
    private final Name carName;
    
    private final Position position;
    
    private final Engine engine;
    
    public Car(String carName) {
        this(carName, 0, new RacingEngine());
    }
    
    public Car(String carName, int position, Engine engine) {
        this(Name.from(carName), Position.from(position), engine);
    }
    
    public Car(Name carName, Position position, Engine engine) {
        this.carName = carName;
        this.position = position;
        this.engine = engine;
    }
    
    public Car move() {
        if (engine.isEnoughFuel()) {
            return new Car(carName, position.increase(), engine);
        }
        
        return this;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(position, car.position);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
}
