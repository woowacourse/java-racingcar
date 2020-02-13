package racingGame.controller;

import racingGame.domain.Car;
import racingGame.view.OutputView;

import java.util.*;

public class Output {
    private List<String> winners = new ArrayList<>();
    private Map<String, Integer> carStatus;

    public void initCarStatus(List<String> names) {
        carStatus = new LinkedHashMap<>();
        names.stream().forEach((x) -> carStatus.put(x, 0));
    }

    public String makeCarLog(String name, int position) {
        StringBuilder log = new StringBuilder(name);
        log.append(" : ");
        for (int i = 0; i < position; i++) {
            log.append("-");
        }
        return log.toString();
    }

    public void makeWinnerNames(List<Car> cars) {
        cars.stream().forEach((x) -> x.addWinnerName(winners));

        String winnerNames = String.join(",", winners);
        OutputView.printWinners(winnerNames);
    }

    public void updateCarStatus(String name, int position) {
        carStatus.put(name, position);
    }

    public void printLog() {
        for (String name : carStatus.keySet()) {
            String log = makeCarLog(name, carStatus.get(name));
            OutputView.printLog(log);
        }
        OutputView.printLine();
    }
}
