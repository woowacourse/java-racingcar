package racingcargame.domain;

import java.util.*;

public class EachRaceResultDto {

    private List<Car> cars;

    public EachRaceResultDto(List<Car> cars) {
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

    public Collection<Car> getCar() {
        return Collections.unmodifiableCollection(cars);
    }


}
