package model;

import java.util.List;

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

    public String findWinners() {
        int maxMovement = cars.stream().mapToInt(Car::getMovement).max().getAsInt();
        List<String> winnersName = cars.stream()
                .filter(car -> car.getMovement() == maxMovement)
                .map(Car::getCarName)
                .toList();
        return String.join(", ",winnersName);
    }
}
