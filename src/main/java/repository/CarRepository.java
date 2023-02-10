package repository;

import java.util.List;
import java.util.Map;
import model.Car;

public interface CarRepository {

    void save(Car car);

    int findMoveCountByName(String name);

    Map<String, Integer> findAllNameAndPosition();

    List<Car> findAll();

    void updatePosition(Car car);
}
