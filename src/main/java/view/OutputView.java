package view;

import model.Car;
import model.Cars;

import java.util.List;

import static java.util.stream.Collectors.*;

public class OutputView {

    private final static String RESULT_HEADER = "실행 결과";
    private final static String WINNERS_FORMAT = "%s가 최종 우승했습니다.%n";
    private final static String WINNERS_CONNECTOR = ", ";

    public void printResultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public void printResult(Cars cars) {
        System.out.println(cars);
    }

    public void printWinners(List<Car> winners) {
        System.out.printf(WINNERS_FORMAT, connectWinner(winners));
    }

    private String connectWinner(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(joining(WINNERS_CONNECTOR));
    }
}
