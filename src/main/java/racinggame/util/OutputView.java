package racinggame.util;

import racinggame.domain.LeagueHistory;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void showHistory(final LeagueHistory leagueHistory) {
        System.out.println("실행 결과");
        leagueHistory.values()
                .forEach(trialHistory -> showEachHistory(trialHistory.getTrialHistory()));
    }

    private static void showEachHistory(Map<String, Integer> trialHistory) {
        StringBuilder history = new StringBuilder();

        for (String carName : trialHistory.keySet()) {
            history.append(carName).append(" : ");
            for (int i = 0; i < trialHistory.get(carName); i++) {
                history.append('-');
            }
            history.append('\n');
        }
        System.out.println(history);
    }

    public static void showWinners(final List<String> winners) {
        final String winnerMessage = String.join(", ", winners);

        System.out.println(winnerMessage + "가 최종 우승했습니다.");
    }

    public static void showErrorMessage(final String message) {
        System.err.println(message);
    }
}