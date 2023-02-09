package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private final String ERROR_PREFIX = "[ERROR] ";
    private final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private final String FINAL_RESULT_MESSAGE = "%s가 최종 우승했습니다.";

    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public void printExecutionResult(List<Car> cars) {
        cars.stream()
                .forEach(car -> printCar(car));
    }

    public void printBlankLine() {
        System.out.println();
    }

    public void printCar(Car car) {
        System.out.println(car.getName() + " : " + changePositionToBars(car));
    }

    private String changePositionToBars(Car car) {
        return "-".repeat(car.getPos());
    }

    public void printFinalResult(List<Car> winners) {
        String winnerNames = String.join(", ", getWinnersNames(winners));
        System.out.println(String.format(FINAL_RESULT_MESSAGE,winnerNames));
    }

    private List<String> getWinnersNames(List<Car> winners) {
        return winners.stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }
}
