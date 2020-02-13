package racingCar.view;

import racingCar.domain.Player;

import java.util.List;

public class OutputView {
    private static final String RESULT_HEAD = "실행 결과";
    public static void printResult(List<Player> players) {
        System.out.println(RESULT_HEAD);
        players.forEach(System.out::println);
    }

    public static void printWinners(List<Player> winners) {
        StringBuilder stringBuilder = new StringBuilder();

    }
}
