package view;

import java.util.List;
import model.Cars;

public class OutputView {
    private static final String WINNER_NAME_DELIMITER = ", ";

    private OutputView() {
    }

    public static void printResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printCarNameAndPosition(Cars cars) {
        cars.getCars()
                .forEach(car ->
                        System.out.printf("%s : %s%n", car.getName(), "-".repeat(car.getPosition()))
                );
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(WINNER_NAME_DELIMITER, winners) + "가 최종 우승했습니다.");
    }
}
