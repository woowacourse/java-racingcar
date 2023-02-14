package view;

import domain.Car;

import java.util.List;

import static java.util.stream.Collectors.*;

public class OutputView {

    private static final String RESULT_HEADER = "실행 결과";
    private static final String WINNERS_FORMAT = "%s가 최종 우승했습니다.%n";
    private static final String ROAD = "-";
    private static final String CAR_RESULT_FORMAT = "%s : %s\n";
    private static final String WINNERS_DELIMITER = ", ";

    public void printResultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public void printResult(List<Car> cars) { // Cars 를 다 받아서 작성
        cars.forEach(car -> System.out.print(printCarResult(car)));
        System.out.println();
    }

    private String printCarResult(Car car) {
        return String.format(
                CAR_RESULT_FORMAT,
                car.getName(),
                ROAD.repeat(car.getDistance()));
    }

    public void printWinners(List<Car> winners) {
        System.out.printf(WINNERS_FORMAT, connectWinner(winners));
    }

    private String connectWinner(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(joining(WINNERS_DELIMITER));
    }

}
