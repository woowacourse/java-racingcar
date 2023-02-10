package service;

import exception.ErrorCode;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import model.Car;
import repository.CarRaceResultRepository;

public class CarRaceServiceImpl implements CarRaceService {

    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int MAX_CAR_COUNT = 100;
    private final CarRaceResultRepository carRaceResultRepository;
    private final NumberGenerator numberGenerator;

    public CarRaceServiceImpl(CarRaceResultRepository carRaceResultRepository,
        NumberGenerator numberGenerator) {
        this.carRaceResultRepository = carRaceResultRepository;
        this.numberGenerator = numberGenerator;
    }

    @Override
    public Map<String, Integer> saveCars(final List<String> names) {
        validateCarCount(names);
        names.forEach(name -> carRaceResultRepository.save(new Car(name)));
        return carRaceResultRepository.findAllNameAndPosition();
    }

    @Override
    public Map<String, Integer> move() {
        for (Car car : carRaceResultRepository.findAll()) {
            car.move(numberGenerator.generateNumber(MAX_RANDOM_NUMBER));
            carRaceResultRepository.updatePosition(car);
        }
        return carRaceResultRepository.findAllNameAndPosition();
    }

    @Override
    public List<String> getResult() {
        Map<String, Integer> resultBoard = carRaceResultRepository.findAllNameAndPosition();
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
