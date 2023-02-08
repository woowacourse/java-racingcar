package repository;

import model.Car;

public interface CarRaceResultRepository {

    void save(Car car);

    int findByName(String name);
}
