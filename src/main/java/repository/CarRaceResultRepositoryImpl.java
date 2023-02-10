package repository;

import exception.ErrorCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import model.Car;

public class CarRaceResultRepositoryImpl implements CarRaceResultRepository {

    private final Map<String, Car> board;

    public CarRaceResultRepositoryImpl() {
        this.board = new ConcurrentHashMap<>();
    }

    @Override
    public void save(final Car car) {
        validateCarDuplicate(car.getName());
        board.put(car.getName(), car);
    }

    @Override
    public int findMoveCountByName(final String name) {
        if (board.containsKey(name)) {
            return board.get(name).getCurrentPosition();
        }
        throw new IllegalArgumentException(ErrorCode.CAR_NOT_FOUND.getMessage());
    }

    @Override
    public Map<String, Integer> findAllNameAndPosition() {
        Map<String, Integer> carResult = new HashMap<>();
        board.forEach((name, car) -> carResult.put(name, car.getCurrentPosition()));
        return carResult;
    }

    @Override
    public List<Car> findAll() {
        return new ArrayList<>(board.values());
    }

    @Override
    public void updatePosition(final Car car) {
        board.put(car.getName(), car);
    }

    private void validateCarDuplicate(final String name) {
        if (board.containsKey(name)) {
            throw new IllegalArgumentException(ErrorCode.CAR_NAME_DUPLICATE.getMessage());
        }
    }

}
