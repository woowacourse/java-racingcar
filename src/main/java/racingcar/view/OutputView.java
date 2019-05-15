package racingcar.view;

import java.util.List;

public class OutputView {

    public static void printResult() {
        System.out.println("실행 결과");
    }

    public static void printState(List<String> states) {
        for (String state : states) {
            System.out.println(state);
        }
        System.out.println();
    }

    public static void printWinners(String winners) {
        System.out.println(winners + " 가 우승했습니다!");
    }
}
