package model;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars (String carsName) {
        List<String> carNames = splitCarName(carsName);

        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    private List<String> splitCarName(String carsName) {
        return Arrays.asList(carsName.split(","));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveResult() {
        for (Car car : cars) {
            if(isMove())
                car.moveCar();
        }
    }

    private boolean isMove(){
        Random random = new Random();
        if(random.nextInt(9)>=4)
            return true;
        return false;
    }

    public List<String> getWinners() {
        int maxLocation = cars.stream()
                .max(Comparator.comparingInt(Car::getCarLocation))
                .get().getCarLocation();

        return cars.stream().filter(car -> car.getCarLocation() == maxLocation)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
