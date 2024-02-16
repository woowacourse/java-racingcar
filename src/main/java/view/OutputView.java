package view;

import domain.Car;
import domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String MOVE_RESULT_FORMAT = "%s : %s\n";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public void printInputCarNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printInputCountMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

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
