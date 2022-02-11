package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingRecord;
import racingcar.util.RandomNumberGeneratePolicy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    public static void main(String[] args) {
        RacingGame racingGame = RacingGame.createRacingGame(
            InputView.getCarsName(),
            InputView.getRound(),
            new RandomNumberGeneratePolicy()
        );
        while (racingGame.isContinue()) {
            RacingRecord racingRecord = racingGame.race();
            OutputView.printRacingRecord(racingRecord);
        }
        OutputView.printRacingResult(racingGame.getRacingResult());
    }
}
