package car;

import java.util.Objects;

public class Car {
    private final Name carName;
    
    private static final int CONDITION = 4;
    
    private int position;
    
    public Car(String carName) {
        this(new Name(carName));
    }
    
    public Car(Name carName) {
        this(carName, 0);
    }
    
    public Car(String carName, int position) {
        this(new Name(carName), position);
    }
    
    public Car(Name carName, int position) {
        this.carName = carName;
        this.position = position;
    }
    
    public void moveOrStop() {
        if (RandomUtil.getRandomValue() >= CONDITION) {
            this.position++;
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Car car = (Car) o;
        return position == car.position && Objects.equals(carName, car.carName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }
    
    public int getPosition() {
        return position;
    }
    
    public String getName() {
        return carName.getName();
    }
}
