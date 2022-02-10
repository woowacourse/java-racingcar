package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class CarRepository {

    List<Car> list;

    public CarRepository() {
        list = new ArrayList<>();
    }

    public void save(Car car) {
        list.add(car);
    }

    public Car findByName(String name) {
        return list.stream().filter(c -> c.getName().equals(name)).findFirst().get();
    }

    public List<Car> findAll() {
        return list;
    }
}
