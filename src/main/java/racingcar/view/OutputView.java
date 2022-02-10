package racingcar.view;

import racingcar.model.Cars;

import java.util.List;

public class OutputView {
    public static void printCarsPosition(Cars cars) {
        System.out.print(cars);
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
