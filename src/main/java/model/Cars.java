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

    public void moveCars() {
        cars.forEach(car -> car.move(generator.get()));
    }

    public String getTotalMovementDetails(){
        StringBuilder details = new StringBuilder();
        cars.forEach(car -> details.append(car.getCarName())
                .append(" : ")
                .append("-".repeat(car.getMovement()))
                .append("\n"));
        return details.toString();
    }
}
