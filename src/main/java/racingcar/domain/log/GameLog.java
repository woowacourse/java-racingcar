package racingcar.domain.log;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class GameLog {

    private final Map<Integer, List<LogCar>> gameLog;

    public GameLog() {
        this.gameLog = new HashMap<>();
    }

    public void writeLog(int currentTryCount, Cars currentCars) {
        gameLog.put(currentTryCount, getLogCarList(currentCars));
    }

    private List<LogCar> getLogCarList(Cars cars) {
        List<LogCar> logCarList = new ArrayList<>();
        for (Car car : cars.getCars()) {
            logCarList.add(new LogCar(car.getName(), car.getPosition()));
        }
        return logCarList;
    }


    public List<LogCar> getLog(int tryCount) {
        return gameLog.get(tryCount);
    }

    public int getPositionByName(int tryCount, String name) {
        return findCarByName(tryCount, name).getPosition();
    }

    private LogCar findCarByName(int tryCount, String name) {
        return getLog(tryCount).stream()
                .filter(logCar -> logCar.getName().equals(name))
                .findFirst()
                .orElseThrow();
    }

    public List<String> getWinnerCarNames(int totalTryCount) {
        List<LogCar> logCarList = getLog(totalTryCount);
        int mostFarPosition = getMostFarPosition(logCarList);
        return logCarList.stream()
                .filter(car -> car.isSamePosition(mostFarPosition))
                .map(LogCar::getName)
                .collect(toList());
    }

    private int getMostFarPosition(List<LogCar> carList) {
        return carList.stream()
                .mapToInt(LogCar::getPosition)
                .max()
                .orElseThrow();
    }
}
