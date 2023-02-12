package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars = new ArrayList<>();

    public Cars(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public int getCarsSize() {
        return cars.size();
    }

    public void addDistance(List<Integer> randomNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).addDistance(randomNumbers.get(i));
        }
    }

    public Car getCar(int i) {
        return this.cars.get(i);
    }

    public List<Car> getCars() {
        return cars;
    }
}
