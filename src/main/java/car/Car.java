package car;

import java.util.Objects;

public final class Car {
    
    private static final int DEFAULT_POSITION = 0;
    
    private final Name carName;
    
    private final Position position;
    
    private final Engine engine;
    
    private Car(Builder builder) {
        this.carName = builder.carName;
        this.position = builder.position;
        this.engine = builder.engine;
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
        return new Score(carName.getName(), position.getPosition());
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
    
    public static class Builder {
        
        private final Name carName;
        
        private Position position = Position.from(DEFAULT_POSITION);
        
        private Engine engine = new RacingEngine();
        
        public Builder(String carName) {
            this.carName = Name.from(carName);
        }
        
        public Builder withPosition(int position) {
            this.position = Position.from(position);
            return this;
        }
        
        Builder withFakeEngine(int moveCondition) {
            this.engine = new Engine.Fake(moveCondition);
            return this;
        }
        
        public Car build() {
            return new Car(this);
        }
    }
}
