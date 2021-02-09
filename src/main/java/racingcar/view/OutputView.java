package racingcar.view;

import racingcar.domain.RaceResultDTO;

import java.util.List;

public class OutputView {
    private static final String WINNER_NAME_SEPARATOR = ",";

    private OutputView() {
    }

    public static void println(final String msg) {
        System.out.println(msg);
    }

    public static void printResults(final List<RaceResultDTO> raceResults) {
        raceResults.stream()
                .map(OutputView::makeResultLine)
                .forEach(OutputView::println);
        printLineBreak();
    }

    private static String makeResultLine(RaceResultDTO result) {
        return result.getName() + " : " + makePositionBar(result.getPosition());
    }

    private static String makePositionBar(int position) {
        StringBuilder sb = new StringBuilder();
        while (position-- > 0) {
            sb.append("-");
        }
        return sb.toString();
    }

    public static void printWinner(final String[] winnerNames) {
        String winningMsg = String.join(WINNER_NAME_SEPARATOR, winnerNames) + "가 최종 우승했습니다.";
        println(winningMsg);
    }

    private static void printLineBreak() {
        System.out.println();
    }
}
