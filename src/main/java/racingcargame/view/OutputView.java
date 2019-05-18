package racingcargame.view;

import racingcargame.model.Car;
import racingcargame.model.Winners;

import java.util.List;

public class OutputView {

    public static void printResult(int result) {
        System.out.println("답은 " + result + " 입니다!");
    }

    public static void printCarState(String carState) {
        System.out.println(carState);
    }

    public static void printLineChange() {
        System.out.println();
    }

    public static void printWinners(List<String> winnersNames) {
        String winners = String.join(",", winnersNames);
        System.out.println(winners + " 가 우승했습니다");
    }

    public static void printResultSentence() {
        System.out.println("실행결과");
    }
}
