package racinggame.util;

import racinggame.domain.LeagueHistory;

import java.util.List;

public class OutputView {

    public static void showHistory(final LeagueHistory leagueHistory) {
        System.out.println("실행 결과");
        leagueHistory.values().forEach(System.out::println);
    }

    public static void showWinners(final List<String> winners) {
        final String winnerMessage = String.join(", ", winners);

        System.out.println(winnerMessage + "가 최종 우승했습니다.");
    }

    public static void showErrorMessage(final String message) {
        System.err.println(message);
    }
}