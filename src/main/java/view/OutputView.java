package view;

import domain.Car;
import java.util.Arrays;
import java.util.List;

public class OutputView {
    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printHeadLine() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(String.join(" : ", car.getCarName(), "-".repeat(car.getLocation())));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        winners.removeAll(Arrays.asList("", null));
        for (String name : winners) {
            System.out.print(name);
            printComma(winners, name);
        }
        System.out.println("가 최종 우승했습니다.");
    }

    private static void printComma(List<String> winners, String name) {
        if (winners.indexOf(name) != winners.size() - 1) {
            System.out.print(", ");
        }
    }
}
