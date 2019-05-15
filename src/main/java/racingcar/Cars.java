package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car> {
    private List<Car> carList = new ArrayList<>();

    public Iterator<Car> iterator() {
        return carList.iterator();
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public List<Car> getWinnerList() {
        Car maxCar = Collections.max(carList);
        return carList
                .stream()
                .filter(car -> car.compareTo(maxCar) == 0)
                .collect(Collectors.toList());
    }

    public int size() {
        return carList.size();
    }
}
