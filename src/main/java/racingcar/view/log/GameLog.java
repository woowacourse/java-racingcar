package racingcar.view.log;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import racingcar.domain.Cars;
import racingcar.view.View;

public class GameLog {

    private static final String PROGRESS_BAR = "-";
    private static final String NAME_AND_PROGRESS_BAR_DELIMITER = " : ";
    private static final String WINNER_RESULT_SUFFIX_MESSAGE = "가 최종 우승했습니다.";
    private static final String WINNER_NAMES_DELIMITER = ", ";

    private final Map<Integer, List<CarForLog>> gameLog;

    public GameLog() {
        this.gameLog = new HashMap<>();
    }

    public void writeLog(int currentTryCount, Cars currentCars) {
        gameLog.put(currentTryCount, currentCars.generateCarForLogList());
    }

    public void printMidtermResults(int currentTryCount) {
        for (CarForLog carForLog : getSingleLog(currentTryCount)) {
            String name = carForLog.getName();
            printCarNameAndProgressBar(name, getPositionByName(currentTryCount, name));
        }
        View.getInstance().printBlankLine();
    }

    private void printCarNameAndProgressBar(String name, int position) {
        System.out.println(name + NAME_AND_PROGRESS_BAR_DELIMITER + getProgressBar(position));
    }

    private String getProgressBar(int position) {
        return IntStream
                .range(0, position)
                .mapToObj(i -> PROGRESS_BAR)
                .reduce("", (a, b) -> a + b);
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

    public void printWinnersResult(int totalTryCount) {
        System.out.println(
                getFormattedWinnerNames(getWinnerCarNames(totalTryCount)) + WINNER_RESULT_SUFFIX_MESSAGE);
    }

    private String getFormattedWinnerNames(List<String> lastCarNames) {
        return lastCarNames.stream()
                .collect(joining(WINNER_NAMES_DELIMITER));
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
