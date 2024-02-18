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
    public static void printWinners(List<Car> winners) {
        List<String> result = winners.stream()
                .filter(Car::getResult)
                .map(Car::getCarName)
                .toList();

        System.out.print(String.join(", ", result));
        System.out.println("가 최종 우승했습니다.");
    }
}
