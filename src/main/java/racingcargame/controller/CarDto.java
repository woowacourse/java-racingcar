package racingcargame.controller;

import racingcargame.domain.Car;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarDto {

    private List<Car> cars;

    public CarDto(List<Car> cars) {
        this.cars = cloneCars(cars);
    }

    private List<Car> cloneCars(List<Car> cars) {
        List<Car> tempCars = new ArrayList<>();
        Iterator<Car> iterator = cars.iterator();

        while (iterator.hasNext()) {
            tempCars.add(new Car(iterator.next()));
        }
        return tempCars;
    }

    public List<Car> getCar() {
        return cars;
    }


}
