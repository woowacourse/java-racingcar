package model;

import java.util.List;
import java.util.function.Supplier;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        cars.forEach(Car::move);
    }

    public String getTotalMovementDetails(){
        StringBuilder details = new StringBuilder();
        cars.forEach(car -> details.append(car.getCarName())
                .append(" : ")
                .append(car.generateMovement())
                .append("\n"));
        return details.toString();
    }
}
