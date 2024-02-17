package view;

import domain.Car;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printHeadLine() {
        System.out.println();
        System.out.println("실행 결과");
    }

    // dash repeat with another method
    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + repeatDash(car.getLocation()));
        }
        System.out.println();
    }

    private static StringBuilder repeatDash(int repeatCount) {
        StringBuilder dash = new StringBuilder();
        dash.append("-".repeat(Math.max(0, repeatCount)));
        return dash;
    }

    //print string "," with stream
    public static void printWinners(List<String> winners) {
        winners.removeAll(Arrays.asList("", null));
        System.out.print(String.join(", ", winners));
        System.out.println("가 최종 우승했습니다.");
    }
}
