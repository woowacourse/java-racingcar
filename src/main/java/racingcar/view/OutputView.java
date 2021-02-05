package racingcar.view;

import java.util.List;

public class OutputView {
    public static void printStartRace() {
        System.out.println("실행 결과");
    }

    public static void printCarInfo(String name, String position) {
        System.out.println(name + " : " + position);
    }

    public static void printOneLine() {
        System.out.println();
    }

    public static void printWinners(List<String> winnersName) {
        System.out.println(String.join(", ", winnersName) + "가 최종 우승했습니다.");
    }
}
