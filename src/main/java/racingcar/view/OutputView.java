package racingcar.view;

import racingcar.domain.result.RacingGameResult;
import racingcar.domain.result.RacingGameRound;
import racingcar.util.PrintUtil;

import java.util.List;

public class OutputView {
    private static final String COMMA = ", ";

    private OutputView() {}

    public static void showRacingGameResult(RacingGameResult racingGameResult) {
        List<RacingGameRound> gameResultDB = racingGameResult.getGameResult();

        System.out.println("\n실행 결과");
        for (RacingGameRound round : gameResultDB) {
            System.out.println(round);
            PrintUtil.sleep();
        }
    }

    public static void showWinners(RacingGameResult racingGameResult) {
        String winners = String.join(COMMA, racingGameResult.getFinalWinners());
        System.out.println(winners + " 이(가) 최종 우승했습니다.");
    }
}
