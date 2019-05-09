package racingcar.view;

import racingcar.domain.result.RacingGameResult;
import racingcar.domain.result.RacingGameRound;
import racingcar.util.PrintUtil;

import java.util.List;

public class OutputView {

    private OutputView() {}

    public static void showRacingGameResult(RacingGameResult racingGameResult) {
        List<RacingGameRound> gameResultDB = racingGameResult.getGameResultDB();

        System.out.println("실행 결과");
        for (RacingGameRound round : gameResultDB) {
            System.out.println(round);
            PrintUtil.pause();
        }
    }
}
