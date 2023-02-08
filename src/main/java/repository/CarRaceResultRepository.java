package repository;

import java.util.Map;
import model.Car;

public interface CarRaceResultRepository {

    void save(Car car);

    int findByName(String name);

    Map<String, Integer> getRaceResult();
}
