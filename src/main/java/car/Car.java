package car;

public class Car {
    private Name carName;
    
    private Position position;
    
    public Car(String carName) {
        this(new Name(carName));
    }
    
    public Car(Name carName) {
        this(carName, new Position());
    }
    
    public Car(Name carName, Position position) {
        this.carName = carName;
        this.position = position;
    }
    
    public Car move() {
        return new Car(carName, position.move());
    }
}
