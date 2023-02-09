package repository;

import exception.ErrorCode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import model.Car;

public class CarRaceResultRepositoryImpl implements CarRaceResultRepository {

    private static final int INITIAL_MOVE_VALUE = 1;
    private static final int MOVE_UNIT = 1;
    private final Map<Car, Integer> moveCountBoard;

    public CarRaceResultRepositoryImpl() {
        this.moveCountBoard = new ConcurrentHashMap<>();
    }

    @Override
    public void save(final Car car) {
        validateCarDuplicate(car);
        moveCountBoard.put(car, INITIAL_MOVE_VALUE);
    }

    @Override
    public int findByName(final String name) {
        return moveCountBoard.get(moveCountBoard
            .keySet()
            .stream()
            .filter(car -> car.getName().equals(name))
            .findAny()
            .orElseThrow(
                () -> new IllegalArgumentException(ErrorCode.CAR_NOT_FOUND.getMessage())));
    }

    @Override
    public Map<String, Integer> getRaceResult() {
        Map<String, Integer> nameResult = new HashMap<>();
        moveCountBoard.forEach((key, value) -> nameResult.put(key.getName(), value));
        return nameResult;
    }

    @Override
    public List<String> findAllCars() {
        return moveCountBoard.keySet()
            .stream()
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    @Override
    public void moveByName(final String name) {
        Car car = moveCountBoard
            .keySet()
            .stream()
            .filter(key -> key.getName().equals(name))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(ErrorCode.CAR_NOT_FOUND.getMessage()));
        moveCountBoard.replace(car, moveCountBoard.get(car) + MOVE_UNIT);
    }

    private void validateCarDuplicate(final Car car) {
        if (moveCountBoard.containsKey(car)) {
            throw new IllegalArgumentException(ErrorCode.CAR_NAME_DUPLICATE.getMessage());
        }
    }
}
