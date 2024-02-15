package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public static void println() {
        System.out.println();
    }

    public static void println(String text) {
        System.out.println(text);
    }

    public static void print(String text) {
        System.out.print(text);
    }

    public static void printResultDescription() {
        println();
        println("실행 결과");
    }

    public static void printPosition(Car car) {
        print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        println();
    }

    public static void printExceptionMessage(String message) {
        println(message);
    }

    public static void printWinnerList(List<Car> winnerList) {
        List<String> names = winnerList.stream()
                .map(Car::getName)
                .toList();

        String winnerNames = String.join(", ", names);
        println(winnerNames + "가 최종 우승했습니다.");
    }

    public static void printNoWinner() {
        println("최대 이동 거리가 0이므로 우승한 자동차가 없습니다.");
    }
}
