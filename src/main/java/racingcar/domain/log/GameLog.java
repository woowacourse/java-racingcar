package racingcar.domain.log;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class GameLog {

    private final Map<Integer, List<CarForLog>> gameLog;

    public GameLog() {
        this.gameLog = new HashMap<>();
    }

    public void writeLog(int currentTryCount, Cars currentCars) {
        gameLog.put(currentTryCount, currentCars.generateCarForLogList());
    }

    public List<CarForLog> getSingleLog(int tryCount) {
        return gameLog.get(tryCount);
    }

    public int getPositionByName(int tryCount, String name) {
        return findCarForLogByName(tryCount, name).getPosition();
    }

    private CarForLog findCarForLogByName(int tryCount, String name) {
        return getSingleLog(tryCount).stream()
                .filter(carForLog -> carForLog.getName().equals(name))
                .findFirst()
                .orElseThrow();
    }

    public List<String> getWinnerCarNames(int totalTryCount) {
        List<CarForLog> carForLogList = getSingleLog(totalTryCount);
        int mostFarPosition = getMostFarPosition(carForLogList);
        return carForLogList.stream()
                .filter(car -> car.isSamePosition(mostFarPosition))
                .map(CarForLog::getName)
                .collect(toList());
    }

    private int getMostFarPosition(List<CarForLog> carList) {
        return carList.stream()
                .mapToInt(CarForLog::getPosition)
                .max()
                .orElseThrow();
    }
}
