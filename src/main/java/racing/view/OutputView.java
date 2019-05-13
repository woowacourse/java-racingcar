package racing.view;

import racing.domain.RacingResult;
import racing.utils.Helper;

/**
 * 사용자의 출력에 관한 클래스
 *
 * @author imkimheejoo
 * @version 1.0.0
 */
public class OutputView {
    public static final String PROCESS_RESULT_MESSAGE = "실행결과";
    private static final String FINAL_WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void printResults(RacingResult racingResult) {
        System.out.println(racingResult.makeRoundResult());
    }

    public static void printAllWinners(RacingResult racingResult) {
        System.out.println(getWinnersName(racingResult) + FINAL_WINNER_MESSAGE);
    }

    private static String getWinnersName(RacingResult racingResult) {
        return String.join(Helper.COMMA, racingResult.searchWinners());
    }
}
