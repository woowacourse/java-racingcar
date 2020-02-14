package racinggame.domain;

import racinggame.domain.Car;
import racinggame.view.OutputView;

import java.util.*;

public class Output {
    private static final String LOG_DELIMITER = " : ";
    private static final String POSITION_CHARACTER = "-";
    private static final String SPLIT_DELIMITER = ",";

    private List<String> winners = new ArrayList<>();
    private Map<String, Integer> carStatus;

    public void initCarStatus(List<String> names) {
        carStatus = new LinkedHashMap<>();
        names.stream().forEach(name -> carStatus.put(name, 0));
    }

    public String makeCarLog(String name, int position) {
        StringBuilder log = new StringBuilder(name);
        log.append(LOG_DELIMITER);
        for (int i = 0; i < position; i++) {
            log.append(POSITION_CHARACTER);
        }
        return log.toString();
    }

    public void makeWinnerNames(List<Car> cars) {
        cars.stream().forEach(car -> car.addWinnerName(winners));

        String winnerNames = String.join(SPLIT_DELIMITER, winners);
        OutputView.printWinners(winnerNames);
    }

    public void updateCarStatus(String name, int position) {
        carStatus.put(name, position);
    }

    public void printLog() {
        for (Map.Entry<String, Integer> entry : carStatus.entrySet()) {
            String name = entry.getKey();
            String log = makeCarLog(name, carStatus.get(name));
            OutputView.printLog(log);
        }
        OutputView.printLine();
    }

    public boolean isContainName(String name) {
        return winners.contains(name);
    }
}
