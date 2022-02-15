package racingcar.domain.result;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class GameLog {

    private final HashMap<Integer, List<Car>> log;

    public GameLog() {
        this.log = new HashMap<>();
    }

    public void writeLog(int currentTryCount, Cars currentCars) {
        log.put(currentTryCount, currentCars.cloneCarList());
    }

    public List<String> getLatestCarNames() {
        return log.get(getLatestTryCount()).stream()
                .map(Car::getName)
                .collect(toList());
    }

    public int getLatestTryCount() {
        return log.size();
    }

    public int getPositionByName(int tryCount, String name) {
        return findCarByName(tryCount, name).getPosition();
    }

    private Car findCarByName(int tryCount, String name) {
        return log.get(tryCount).stream()
                .filter(car -> car.getName().equals(name))
                .findFirst()
                .get();
    }

    public List<String> getWinnerCarNames() {
        List<Car> carList = log.get(getLatestTryCount());
        int mostFarPosition = getMostFarPosition(carList);
        return carList.stream()
                .filter(car -> car.isSamePosition(mostFarPosition))
                .map(Car::getName)
                .collect(toList());
    }

    private int getMostFarPosition(List<Car> carList) {
        int defaultPosition = 0;
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(defaultPosition);
    }
}
