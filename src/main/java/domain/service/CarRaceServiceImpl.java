package domain.service;

import domain.exception.ErrorCode;
import domain.model.Car;
import domain.model.Name;
import domain.repository.CarRaceResultRepository;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CarRaceServiceImpl implements CarRaceService {

    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int MOVE_LIMIT = 4;
    private static final int MAX_CAR_COUNT = 100;
    private final CarRaceResultRepository carRaceResultRepository;
    private final NumberGenerator numberGenerator;

    public CarRaceServiceImpl(CarRaceResultRepository carRaceResultRepository,
        NumberGenerator numberGenerator) {
        this.carRaceResultRepository = carRaceResultRepository;
        this.numberGenerator = numberGenerator;
    }

    @Override
    public Map<Name, Integer> saveCars(final List<String> names) {
        validateCarCount(names);
        trySaveCar(names);
        return carRaceResultRepository.getRaceResult();
    }

    @Override
    public Map<Name, Integer> move() {
        List<Name> cars = carRaceResultRepository.findAllCars();
        cars.forEach(this::moveCar);
        return carRaceResultRepository.getRaceResult();
    }

    @Override
    public List<Name> getResult() {
        Map<Name, Integer> resultBoard = carRaceResultRepository.getRaceResult();
        Integer max = Collections.max(resultBoard.values());
        return resultBoard.entrySet()
            .stream()
            .filter(status -> status.getValue().equals(max))
            .map(Entry::getKey)
            .collect(Collectors.toList());
    }

    private void trySaveCar(List<String> names) {
        try {
            names.forEach(name -> carRaceResultRepository.save(new Car(new Name(name))));
        } catch (IllegalArgumentException e) {
            carRaceResultRepository.clear();
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void moveCar(final Name name) {
        if (numberGenerator.generateNumber(MAX_RANDOM_NUMBER) >= MOVE_LIMIT) {
            carRaceResultRepository.moveByName(name);
        }
    }

    private void validateCarCount(final List<String> names) {
        if (names.size() > MAX_CAR_COUNT) {
            throw new IllegalArgumentException(
                String.format(ErrorCode.TOO_MANY_CAR.getMessage(), MAX_CAR_COUNT));
        }
    }
}
