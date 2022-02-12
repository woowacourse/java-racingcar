package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingRecord;
import racingcar.domain.RandomNumberGeneratePolicy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    public static void main(String[] args) {
        RacingGame racingGame = RacingGame.createRacingGame(
            InputView.getCarsName(),
            InputView.getRound(),
            new RandomNumberGeneratePolicy()
        );
        OutputView.printRacingRecordHeadLine();
        while (racingGame.hasNextGame()) {
            RacingRecord racingRecord = racingGame.race();
            OutputView.printRacingRecord(racingRecord);
        }
        OutputView.printRacingResult(racingGame.getRacingResult());
    }
}
