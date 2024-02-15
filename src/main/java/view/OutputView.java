package view;

import domain.Car;
import domain.Cars;
import dto.Winners;

public class OutputView {
    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        printNewLine();
    }

    public static void printWinners(Winners winners) {
        System.out.println(String.join(", " ,winners.winners()) + "가 최종 우승했습니다.");
    }
}
