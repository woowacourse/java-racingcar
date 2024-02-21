package view;

import domain.Car;
import domain.Cars;
import java.util.List;

public class OutputView {
    private static final String RESULT_DELIMITER = " : ";
    private static final String GO_COUNT = "-";

    public OutputView() {
    }

    public static void printHeadLine() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(String.join(RESULT_DELIMITER, car.getCarName(), GO_COUNT.repeat(car.getLocation())));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        for (String name : winners) {
            System.out.print(name);
            printComma(winners, name);
        }
        System.out.println("가 최종 우승했습니다.");
    }

    private void printComma(List<String> winners, String name) {
        if (winners.indexOf(name) != winners.size() - 1) {
            System.out.print(", ");
        }
    }
}
