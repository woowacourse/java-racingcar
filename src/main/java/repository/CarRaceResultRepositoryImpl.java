package repository;

import exception.ErrorCode;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import model.Car;

public class CarRaceResultRepositoryImpl implements CarRaceResultRepository {

    private static final int INITIAL_MOVE_COUNT = 1;
    private static final Map<Car, Integer> moveCountBoard = new ConcurrentHashMap<>();
    private static CarRaceResultRepositoryImpl instance;

    private CarRaceResultRepositoryImpl() {}

    public static synchronized CarRaceResultRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CarRaceResultRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void save(Car car) {
        validateCarDuplicate(car);
        moveCountBoard.put(car, INITIAL_MOVE_COUNT);
    }

    @Override
    public int findByName(String name) {
        return moveCountBoard.get(
            moveCountBoard.keySet().stream().filter(car -> car.getName().equals(name)).findAny()
                .orElseThrow(
                    () -> new IllegalArgumentException(ErrorCode.CAR_NOT_FOUND.getMessage())));
    }

    @Override
    public Map<String, Integer> getRaceResult() {
        Map<String, Integer> nameResult = new HashMap<>();
        moveCountBoard.forEach((key, value) -> nameResult.put(key.getName(), value));
        return nameResult;
    }

    private void validateCarDuplicate(Car car) {
        if (moveCountBoard.containsKey(car)) {
            throw new IllegalArgumentException(ErrorCode.CAR_NAME_DUPLICATE.getMessage());
        }
    }
}
