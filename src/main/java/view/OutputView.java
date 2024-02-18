package view;

import domain.Car;
import domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String MOVE_RESULT_FORMAT = "%s : %s\n";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public void printMoveResultMessage() {
        System.out.println(LINE_SEPARATOR + "실행 결과");
    }

    public void printMoveResult(Cars cars) {
        cars.getCars().forEach(car ->
                System.out.printf(MOVE_RESULT_FORMAT, car.getName(), "-".repeat(car.getLocation())));
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        System.out.println(
                winners.stream()
                        .map(Car::getName)
                        .collect((Collectors.joining(", ", "", "가 최종 우승했습니다.")))
        );
    }
}
