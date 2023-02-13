package domain.repository;

import java.util.List;
import java.util.Map;
import domain.model.Car;

public interface CarRaceResultRepository {

    void save(Car car);

    int findByName(String name);

    Map<String, Integer> getRaceResult();

    List<String> findAllCars();

    void moveByName(String name);
}
