package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Cars implements Iterable<Car> {
    private List<Car> carList = new ArrayList<>();

    public Iterator<Car> iterator() {
        return carList.iterator();
    }

    public int size() {
        return carList.size();
    }

    void addCar(Car car) {
        carList.add(car);
    }

    Car getMaxAdvancedCar() {
        return Collections.max(carList);
    }
}
