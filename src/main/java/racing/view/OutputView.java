package racing.view;

import racing.domain.RacingGameResult;

public class OutputView {
    private static final String PROCESS_RESULT_MESSAGE = "실행결과";
    private static final String FINAL_WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void printRacingResult(RacingGameResult allResults) {
        System.out.println(PROCESS_RESULT_MESSAGE);
        System.out.println(allResults.makeAllResults());
    }

    public static void printAllWinners(RacingGameResult allResult) {
        System.out.println(allResult.searchWinners() + FINAL_WINNER_MESSAGE);
    }
}
