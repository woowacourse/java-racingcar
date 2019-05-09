package racingcar.view;

import racingcar.domain.result.RacingGameResult;
import racingcar.domain.result.RacingGameRound;

import java.util.List;

public class OutputView {

    private OutputView() {}

    public static void showRacingGameResult(RacingGameResult racingGameResult) {
        List<RacingGameRound> gameResultDB = racingGameResult.getGameResultDB();

        System.out.println("실행 결과");

    }
}
