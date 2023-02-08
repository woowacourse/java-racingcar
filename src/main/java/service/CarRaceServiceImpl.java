package service;

import java.util.List;
import java.util.Map;
import model.Car;
import repository.CarRaceResultRepository;

public class CarRaceServiceImpl implements CarRaceService {
    private final CarRaceResultRepository carRaceResultRepository;

    public CarRaceServiceImpl(CarRaceResultRepository carRaceResultRepository) {
        this.carRaceResultRepository = carRaceResultRepository;
    }

    @Override
    public Map<String, Integer> saveCars(List<String> names) {
        names.forEach(name -> carRaceResultRepository.save(new Car(name)));
        return carRaceResultRepository.getRaceResult();
    }
}
