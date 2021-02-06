package car.domain;

import car.domain.engine.Engine;
import car.domain.engine.RacingEngine;

import java.util.Objects;

final class Car {
    
    private final Name carName;
    
    private final Position position;
    
    private final Engine engine;
    
    public Car(String carName) {
        this(carName, new RacingEngine());
    }
    
    public Car(String carName, Engine engine) {
        this(Name.from(carName), new Position(), engine);
    }
    
    public Car(String carName, int position, Engine engine) {
        this(Name.from(carName), Position.from(position), engine);
    }
    
    private Car(Name carName, Position position, Engine engine) {
        this.carName = carName;
        this.position = position;
        this.engine = engine;
    }
    
    public Car move() {
        if (engine.isEnoughFuel()) {
            return move(this);
        }
        
        return this;
    }
    
    private Car move(Car car) {
        return new Car(car.carName, car.position.increase(), car.engine);
    }
    
    public Score getScore() {
        return new Score(carName, position);
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
