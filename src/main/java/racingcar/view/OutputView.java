package racingcar.view;

import racingcar.domain.result.RacingGameResult;
import racingcar.domain.result.RacingGameRound;
import racingcar.utils.PrintUtils;
import racingcar.utils.StringUtils;

import java.util.List;

public class OutputView {
    private static final String COMMA = ", ";

    private OutputView() {
    }

    public static void showRacingGameProcess(RacingGameResult racingGameResult) {
        List<RacingGameRound> gameResultDB = racingGameResult.getGameResultHistory();

        System.out.println(StringUtils.ENTER + "실행 결과");
        for (RacingGameRound round : gameResultDB) {
            System.out.println(round);
            PrintUtils.sleep();
        }
    }

    public static void showWinners(RacingGameResult racingGameResult) {
        String winners = String.join(COMMA, racingGameResult.getNamesOfWinners());
        System.out.println(winners + " 이(가) 최종 우승했습니다.");
    }
}
