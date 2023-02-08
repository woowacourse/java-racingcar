package service;

import java.util.List;
import java.util.Map;
import model.Car;
import repository.CarRaceResultRepository;
import util.RandomNumberGenerator;

public class CarRaceServiceImpl implements CarRaceService {
    private static final int MAX_NUMBER = 10;
    private static final int MOVE_LIMIT = 4;
    private final CarRaceResultRepository carRaceResultRepository;
    private final RandomNumberGenerator randomNumberGenerator;

    public CarRaceServiceImpl(CarRaceResultRepository carRaceResultRepository, RandomNumberGenerator randomNumberGenerator) {
        this.carRaceResultRepository = carRaceResultRepository;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public Map<String, Integer> saveCars(List<String> names) {
        names.forEach(name -> carRaceResultRepository.save(new Car(name)));
        return carRaceResultRepository.getRaceResult();
    }

    @Override
    public Map<String, Integer> move() {
        List<String> cars = carRaceResultRepository.findAllCars();
        cars.forEach(this::moveCar);
        return carRaceResultRepository.getRaceResult();
    }

    private void moveCar(String car) {
        if (randomNumberGenerator.generateRandomNumber(MAX_NUMBER) >= MOVE_LIMIT) {
            carRaceResultRepository.moveByName(car);
        }
    }
}
