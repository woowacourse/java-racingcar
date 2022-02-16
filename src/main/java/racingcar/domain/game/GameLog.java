package racingcar.domain.game;

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

    public List<Car> getLog(int tryCount) {
        return log.get(tryCount);
    }

    public int getPositionByName(int tryCount, String name) {
        return findCarByName(tryCount, name).getPosition();
    }

    private Car findCarByName(int tryCount, String name) {
        return getLog(tryCount).stream()
                .filter(car -> car.getName().equals(name))
                .findFirst()
                .get();
    }

    public List<String> getWinnerCarNames(int totalTryCount) {
        List<Car> carList = getLog(totalTryCount);
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
