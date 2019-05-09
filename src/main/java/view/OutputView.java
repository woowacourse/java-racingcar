package view;

import model.Car;

import java.util.List;

public class OutputView {
    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printLapReseult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
