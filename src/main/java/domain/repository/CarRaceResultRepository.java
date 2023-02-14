package domain.repository;

import domain.model.Car;
import domain.model.Name;
import java.util.List;
import java.util.Map;

public interface CarRaceResultRepository {

    void save(Car car);

    int findByName(Name name);

    Map<Name, Integer> getRaceResult();

    List<Name> findAllCars();

    void moveByName(Name name);
}
