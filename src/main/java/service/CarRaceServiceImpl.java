package service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import model.Car;
import repository.CarRaceResultRepository;

public class CarRaceServiceImpl implements CarRaceService {

    private static final int MAX_NUMBER = 10;
    private static final int MOVE_LIMIT = 4;
    private final CarRaceResultRepository carRaceResultRepository;
    private final RandomNumberGenerator randomNumberGenerator;

    public CarRaceServiceImpl(CarRaceResultRepository carRaceResultRepository,
        RandomNumberGenerator randomNumberGenerator) {
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

    @Override
    public List<String> getResult() {
        Map<String, Integer> resultBoard = carRaceResultRepository.getRaceResult();
        Integer max = Collections.max(resultBoard.values());
        return resultBoard.entrySet()
            .stream()
            .filter(entry -> entry.getValue().equals(max))
            .map(Entry::getKey)
            .collect(Collectors.toList());
    }

    private void moveCar(String car) {
        if (randomNumberGenerator.generateRandomNumber(MAX_NUMBER) >= MOVE_LIMIT) {
            carRaceResultRepository.moveByName(car);
        }
    }
}
