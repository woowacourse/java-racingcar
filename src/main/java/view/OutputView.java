package view;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private static final String OUTPUT_RESULT_MESSAGE = "\n실행 결과";

    public static void showRaceResult() {
        System.out.println(OUTPUT_RESULT_MESSAGE);
    }

    public static void showRoundResult(List<String> carNames, List<String> carDistances) {
        StringBuilder roundResult = new StringBuilder();

        for (int i = 0; i < carNames.size(); i++) {
            roundResult.append(carNames.get(i))
                    .append(" : ")
                    .append(carDistances.get(i))
                    .append("\n");
        }

        System.out.println(roundResult);
    }

    public static void showWinners(List<String> winners) {
        StringJoiner result = new StringJoiner(", ", "", "가 최종 우승했습니다.");
        for (String winner : winners) {
            result.add(winner);
        }
        System.out.println(result);
    }
}
