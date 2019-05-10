package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarGenerator {
    List<Car> cars;

    public CarGenerator(){
        cars = new ArrayList<>();
    }

    public void generateCars(String[] carNames){
        for(String carName : carNames){
            cars.add(new Car(carName));
        }
    }

    public List<Car> generateCars2(String[] carNames){
        for(String carName : carNames){
            cars.add(new Car(carName));
        }
        return this.cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarGenerator that = (CarGenerator) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
