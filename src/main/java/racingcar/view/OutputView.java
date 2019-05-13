package racingcar.view;

import racingcar.Winners;

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

    public static void printWinners(Winners winners) {
        System.out.println(winners.getWinners() + " 가 우승했습니다!");
    }
}
