package model;

import java.util.List;
import java.util.function.Supplier;

public class Cars {
    private final List<Car> cars;
    private final Supplier<Integer> generator;

    public Cars(List<Car> cars, Supplier<Integer> generator) {
        this.cars = cars;
        this.generator = generator;
    }

    public void totalCarMovement(int tryNumber) {
        for(int i = 0; i<tryNumber;i++){
            moveCars();
        }
    }

    private void moveCars() {
        cars.forEach(car -> car.move(generator.get()));
    }
}
