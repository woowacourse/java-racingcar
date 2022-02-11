package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    public static void printRoundResultText() {
        print("\n실행 결과");
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            printCarNameCurrentPosition(car);
        }
        print("");
    }

    public static void printCarNameCurrentPosition(Car car) {
        StringBuilder sb = new StringBuilder();

        sb.append(car.getName()).append(" : ");

        for (int i = 0; i < car.getPosition(); i++) {
            sb.append("-");
        }

        print(sb.toString());
    }

    public static void printWinners(List<Car> winners) {
        StringJoiner joiner = new StringJoiner(", ");

        for (Car winner : winners) {
            joiner.add(winner.getName());
        }

        String winnerNames = joiner.toString();
        print(winnerNames + "가 최종 우승했습니다.");
    }

    private static void print(String string) {
        System.out.println(string);
    }
}
