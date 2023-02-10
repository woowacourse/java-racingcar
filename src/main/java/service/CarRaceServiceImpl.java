package service;

import exception.ErrorCode;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import model.Car;
import repository.CarRepository;

public class CarRaceServiceImpl implements CarRaceService {

    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int MAX_CAR_COUNT = 100;
    private final CarRepository carRepository;
    private final NumberGenerator numberGenerator;

    public CarRaceServiceImpl(CarRepository carRepository,
        NumberGenerator numberGenerator) {
        this.carRepository = carRepository;
        this.numberGenerator = numberGenerator;
    }

    @Override
    public Map<String, Integer> saveCars(final List<String> names) {
        validateCarCount(names);
        names.forEach(name -> carRepository.save(new Car(name)));
        return carRepository.findAllNameAndPosition();
    }

    @Override
    public Map<String, Integer> move() {
        for (Car car : carRepository.findAll()) {
            car.move(numberGenerator.generateNumber(MAX_RANDOM_NUMBER));
            carRepository.updatePosition(car);
        }
        return carRepository.findAllNameAndPosition();
    }

    @Override
    public List<String> getResult() {
        Map<String, Integer> resultBoard = carRepository.findAllNameAndPosition();
        Integer max = Collections.max(resultBoard.values());
        return resultBoard.entrySet()
            .stream()
            .filter(status -> status.getValue().equals(max))
            .map(Entry::getKey)
            .collect(Collectors.toList());
    }

    private void validateCarCount(final List<String> names) {
        if (names.size() > MAX_CAR_COUNT) {
            throw new IllegalArgumentException(
                String.format(ErrorCode.TOO_MANY_CAR.getMessage(), MAX_CAR_COUNT));
        }
    }

}
